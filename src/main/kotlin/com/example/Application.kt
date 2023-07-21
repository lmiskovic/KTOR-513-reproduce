package com.example

import com.google.appengine.api.ThreadManager
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.util.logging.*
import java.util.*
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

val LOGGER = KtorSimpleLogger("APP_LOGGER")

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

val mailSession = Session.getDefaultInstance(Properties())

fun Application.module() {
    routing {
        get("/sendEmail") {
            ThreadManager.createBackgroundThread {
                try {
                    val message: Message = MimeMessage(mailSession)
                    message.setFrom(InternetAddress("noreply@sample.com"))
                    message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse("sampleAddress@sample.com")
                    )

                    message.subject = "Subject"
                    message.setText("This is test body")
                    Transport.send(message)
                } catch (e: MessagingException) {
                    LOGGER.error(e.stackTraceToString())
                }
            }
        }
    }
}

