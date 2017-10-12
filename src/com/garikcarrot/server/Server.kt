package com.garikcarrot.server

import com.garikcarrot.protocol.requests.ImageRequest
import org.lwjgl.opengl.XRandR
import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.net.Socket
import javax.imageio.ImageIO


/**
 * Created by garik-carrot on 10.10.17.
 */
fun main(args: Array<String>) {
    while (true) {
        val client = Socket(args[0], args[1].toInt())
        val request = ImageRequest(subcreen(), "jpg")
        val output = client.outputStream
        output.write(test(request.image, "png").toByteArray())
        client.close()
    }
}

fun subcreen(): BufferedImage {
    val a = XRandR.getResolutions("VIRTUAL1")[0]
    val b = XRandR.getResolutions("eDP1")[0]
    val screenRect = Rectangle(Toolkit.getDefaultToolkit().screenSize)
    val capture = Robot().createScreenCapture(screenRect)
    val c = capture.getSubimage(b.width, 0, a.width, a.height);
    return c
}

fun test(image: BufferedImage, ext: String): ByteArrayOutputStream {
    val baos = ByteArrayOutputStream()
    ImageIO.write(image, ext, baos)
    baos.flush()
    return baos;
}