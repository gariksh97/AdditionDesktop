package com.garikcarrot.client

import com.garikcarrot.client.ui.MainUi
import javafx.application.Application
import java.io.File
import java.net.ServerSocket
import javax.imageio.ImageIO


/**
 * Created by garik-carrot on 10.10.17.
 */
fun main(args: Array<String>) {
    Application.launch(MainUi::class.java, "")
    /*
    val th = Thread({

        val server = ServerSocket(9999)
        println("Server running on port ${server.localPort}")

        while (true) {
            val client = server.accept()
            val image = ImageIO.read(client.inputStream)
            ImageIO.write(image, "jpg", File("dir/serv.jpg"))
            client.close()
        }

        server.close()

    }).start()
    */
}

