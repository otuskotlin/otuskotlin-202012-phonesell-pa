package com.example.helpers

import io.ktor.http.cio.websocket.*
import ru.otus.otuskotlin.phonesell.pa.common.be.repositories.IUserSession

class WsUserSession(
    override val fwSession: WebSocketSession
) : IUserSession<WebSocketSession> {
}
