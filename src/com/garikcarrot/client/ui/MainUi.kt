package com.garikcarrot.client.ui

import javafx.application.Application
import javafx.embed.swing.SwingFXUtils
import javafx.scene.Scene
import javafx.scene.image.ImageView
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.stage.Stage
import java.io.File
import java.net.ServerSocket
import javax.imageio.ImageIO

/**
 * Created by garik-carrot on 11.10.17.
 */

class MainUi : Application() {

    var image = ImageView()
    override fun start(stage: Stage) {
        val root = StackPane()
        val scene = Scene(root, 400.0, 400.0, Color.ORANGE)
        root.children.add(image)
        stage.scene = scene
        stage.title = "Test"
        stage.show()
        val th = Thread({

            val server = ServerSocket(9999)
            println("Server running on port ${server.localPort}")

            while (true) {
                val client = server.accept()
                val image = ImageIO.read(client.inputStream)
                this.image.image = SwingFXUtils.toFXImage(image, null)
                client.close()
            }

            server.close()

        }).start()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(MainUi::class.java)
        }
    }

}