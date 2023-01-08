// generated by codegen/codegen.py
private import codeql.swift.generated.Synth
private import codeql.swift.generated.Raw
import codeql.swift.elements.pattern.Pattern
import codeql.swift.elements.type.TypeRepr

module Generated {
  class TypedPattern extends Synth::TTypedPattern, Pattern {
    override string getAPrimaryQlClass() { result = "TypedPattern" }

    /**
     * Gets the sub pattern of this typed pattern.
     *
     * This includes nodes from the "hidden" AST. It can be overridden in subclasses to change the
     * behavior of both the `Immediate` and non-`Immediate` versions.
     */
    Pattern getImmediateSubPattern() {
      result =
        Synth::convertPatternFromRaw(Synth::convertTypedPatternToRaw(this)
              .(Raw::TypedPattern)
              .getSubPattern())
    }

    /**
     * Gets the sub pattern of this typed pattern.
     */
    final Pattern getSubPattern() { result = getImmediateSubPattern().resolve() }

    /**
     * Gets the type representation of this typed pattern, if it exists.
     *
     * This includes nodes from the "hidden" AST. It can be overridden in subclasses to change the
     * behavior of both the `Immediate` and non-`Immediate` versions.
     */
    TypeRepr getImmediateTypeRepr() {
      result =
        Synth::convertTypeReprFromRaw(Synth::convertTypedPatternToRaw(this)
              .(Raw::TypedPattern)
              .getTypeRepr())
    }

    /**
     * Gets the type representation of this typed pattern, if it exists.
     */
    final TypeRepr getTypeRepr() { result = getImmediateTypeRepr().resolve() }

    /**
     * Holds if `getTypeRepr()` exists.
     */
    final predicate hasTypeRepr() { exists(getTypeRepr()) }
  }
}
