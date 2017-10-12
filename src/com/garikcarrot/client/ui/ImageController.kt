package com.garikcarrot.client.ui

import javafx.embed.swing.SwingFXUtils
import javafx.fxml.FXML
import javafx.scene.image.ImageView
import java.awt.image.BufferedImage

/**
 * Created by garik-carrot on 10.10.17.
 */
interface ImageController {
    fun setImage(image: BufferedImage)
}