package net.naruho.mycheckstyleexperiments.checks;

import com.puppycrawl.tools.checkstyle.api.Check;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class ReturnUsingParenthesesCheck extends Check {

  public int[] getDefaultTokens() {
    return new int[] { TokenTypes.LITERAL_RETURN };
  }

  public void visitToken(DetailAST ast) {
    DetailAST expr = ast.findFirstToken(TokenTypes.EXPR);
    if (expr.getFirstChild().getType() == TokenTypes.LPAREN) {
      log(ast.getLineNo(), "A return statement should not use parentheses");
    }
  }

}
