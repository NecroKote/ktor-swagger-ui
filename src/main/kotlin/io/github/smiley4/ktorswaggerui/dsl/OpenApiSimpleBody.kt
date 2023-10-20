package io.github.smiley4.ktorswaggerui.dsl


/**
 * Describes the base of a single request/response body.
 */
@OpenApiDslMarker
class OpenApiSimpleBody(
    /**
     * The type defining the schema used for the body.
     */
    val type: BodyTypeDescriptor,
) : OpenApiBaseBody() {

    /**
     * Examples for this body
     */
    private val examples = mutableMapOf<String, OpenApiExample>()

    fun example(name: String, value: Any, block: OpenApiExample.() -> Unit) {
        examples[name] = OpenApiExample(value).apply(block)
    }

    fun example(name: String, value: Any) = example(name, value) {}

    fun getExamples(): Map<String, OpenApiExample> = examples

}
