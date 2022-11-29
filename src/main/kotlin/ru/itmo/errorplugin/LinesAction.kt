package ru.itmo.errorplugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import java.awt.Font
import java.nio.file.Files
import java.nio.file.Paths
import javax.swing.*


class LinesAction: AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val psiFile = event.getData(CommonDataKeys.VIRTUAL_FILE)
        val path= psiFile?.canonicalPath

        val fileStream: List<String> = Files.readAllLines(Paths.get(path))
        val lines = fileStream.size

        val label = JLabel("$lines lines")
        label.font = Font("Arial", Font.BOLD, 18)
        val icon1 = ImageIcon("C:\\Users\\Виктория\\Desktop\\github\\viclown\\errorplugin\\src\\main\\images\\1.png")
        val icon2 = ImageIcon("C:\\Users\\Виктория\\Desktop\\github\\viclown\\errorplugin\\src\\main\\images\\2.png")
        val icon3 = ImageIcon("C:\\Users\\Виктория\\Desktop\\github\\viclown\\errorplugin\\src\\main\\images\\3.png")
        val icon4 = ImageIcon("C:\\Users\\Виктория\\Desktop\\github\\viclown\\errorplugin\\src\\main\\images\\4.png")
        val icon5 = ImageIcon("C:\\Users\\Виктория\\Desktop\\github\\viclown\\errorplugin\\src\\main\\images\\5.png")
        val icon6 = ImageIcon("C:\\Users\\Виктория\\Desktop\\github\\viclown\\errorplugin\\src\\main\\images\\6.png")


        when (lines) {
            in 1..10 -> JOptionPane.showMessageDialog(null, label, "$lines lines", JOptionPane.INFORMATION_MESSAGE, icon1)
            in 11..50 -> JOptionPane.showMessageDialog(null, label, "$lines lines", JOptionPane.INFORMATION_MESSAGE, icon2)
            in 51..100 -> JOptionPane.showMessageDialog(null, label, "$lines lines", JOptionPane.INFORMATION_MESSAGE, icon3)
            in 101..500 -> JOptionPane.showMessageDialog(null, label, "$lines lines", JOptionPane.INFORMATION_MESSAGE, icon4)
            in 501..1000 -> JOptionPane.showMessageDialog(null, label, "$lines lines", JOptionPane.INFORMATION_MESSAGE, icon5)
            else -> JOptionPane.showMessageDialog(null, label, "$lines lines", JOptionPane.INFORMATION_MESSAGE, icon6)
        }
    }
}

