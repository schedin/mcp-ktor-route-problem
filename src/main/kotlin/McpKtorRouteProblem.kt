import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.sse.SSE
import io.ktor.server.routing.*
import io.modelcontextprotocol.kotlin.sdk.Implementation
import io.modelcontextprotocol.kotlin.sdk.ServerCapabilities
import io.modelcontextprotocol.kotlin.sdk.server.Server
import io.modelcontextprotocol.kotlin.sdk.server.ServerOptions
import io.modelcontextprotocol.kotlin.sdk.server.mcp

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    install(SSE)

    routing {
        route("myRoute") {
            mcp {
                Server(
                    serverInfo = Implementation(
                        name = "example-sse-server",
                        version = "1.0.0"
                    ),
                    options = ServerOptions(
                        capabilities = ServerCapabilities(
                            prompts = ServerCapabilities.Prompts(listChanged = null),
                            resources = ServerCapabilities.Resources(subscribe = null, listChanged = null)
                        )
                    )
                )
            }
        }
    }
}

