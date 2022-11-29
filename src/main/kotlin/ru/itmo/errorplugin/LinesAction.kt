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

        when (lines) {
            in 1..10 -> showPanel(label, lines, 1)
            in 11..50 -> showPanel(label, lines, 2)
            in 51..100 -> showPanel(label, lines, 3)
            in 101..500 -> showPanel(label, lines, 4)
            in 501..1000 -> showPanel(label, lines, 5)
            else -> showPanel(label, lines, 6)
        }
    }

    private fun showPanel(label: JLabel, lines: Int, icon_num: Int) {
        val icon = ImageIcon("C:\\Users\\Виктория\\Desktop\\github\\viclown\\errorplugin\\src\\main\\images\\$icon_num.png")
        JOptionPane.showMessageDialog(null, label, "$lines lines", JOptionPane.INFORMATION_MESSAGE, icon)
    }
}

