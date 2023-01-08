// generated by codegen/codegen.py
private import codeql.swift.generated.Synth
private import codeql.swift.generated.Raw
import codeql.swift.elements.expr.Expr
import codeql.swift.elements.expr.LookupExpr

module Generated {
  class MethodLookupExpr extends Synth::TMethodLookupExpr, LookupExpr {
    override string getAPrimaryQlClass() { result = "MethodLookupExpr" }

    /**
     * Gets the the underlying method declaration reference expression.
     *
     * This includes nodes from the "hidden" AST. It can be overridden in subclasses to change the
     * behavior of both the `Immediate` and non-`Immediate` versions.
     */
    Expr getImmediateMethodRef() { none() }

    /**
     * Gets the the underlying method declaration reference expression.
     */
    final Expr getMethodRef() { result = getImmediateMethodRef().resolve() }
  }
}
