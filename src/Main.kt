/**
 * ===============================================================
 * Kotlin Colour picker app
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.datatransfer.StringSelection
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*
import javax.swing.event.ChangeEvent
import javax.swing.event.ChangeListener


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}

fun copyToClipboard(text: String) {
    val stringSelection = StringSelection(text)
    val clipboard = Toolkit.getDefaultToolkit().systemClipboard
    clipboard.setContents(stringSelection, null)
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, ChangeListener {

    // Fields to hold the UI elements
    private lateinit var colourLabel: JLabel
    private lateinit var rLabel: JLabel
    private lateinit var gLabel: JLabel
    private lateinit var bLabel: JLabel
    private lateinit var hexLabel: JLabel
    private lateinit var r: JSpinner
    private lateinit var g: JSpinner
    private lateinit var b: JSpinner
    private lateinit var Hex: JTextField
    private lateinit var copy: JButton

    // Store the colour value
    private var _colour = Color(255, 255, 255)


    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(280, 420)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 20)

        colourLabel = JLabel()
        colourLabel.bounds = Rectangle(40, 40, 200, 200)
        colourLabel.background = _colour
        colourLabel.setOpaque(true)
        add(colourLabel)

        rLabel = JLabel("R")
        rLabel.bounds = Rectangle(40, 260, 30, 30)
        rLabel.font = defaultFont
        add(rLabel)

        r = JSpinner(SpinnerNumberModel(255, 0, 255, 1))
        r.bounds = Rectangle(70, 260, 80, 30)
        r.font = defaultFont
        r.foreground = Color.WHITE
        r.background = Color(255, 0, 0)
        r.addChangeListener(this)
        add(r)

        gLabel = JLabel("G")
        gLabel.bounds = Rectangle(40, 300, 30, 30)
        gLabel.font = defaultFont
        add(gLabel)

        g = JSpinner(SpinnerNumberModel(255, 0, 255, 1))
        g.bounds = Rectangle(70, 300, 80, 30)
        g.font = defaultFont
        g.foreground = Color.WHITE
        g.background = Color(0, 255, 0)
        g.addChangeListener(this)
        add(g)

        bLabel = JLabel("B")
        bLabel.bounds = Rectangle(40, 340, 30, 30)
        bLabel.font = defaultFont
        add(bLabel)

        b = JSpinner(SpinnerNumberModel(255, 0, 255, 1))
        b.bounds = Rectangle(70, 340, 80, 30)
        b.font = defaultFont
        b.foreground = Color.WHITE
        b.background = Color(0, 0, 255)
        b.addChangeListener(this)
        add(b)

        hexLabel = JLabel("Hex")
        hexLabel.bounds = Rectangle(40, 380, 90, 30)
        hexLabel.font = defaultFont
        add(hexLabel)

        Hex = JTextField("#FFFFFF")
        Hex.bounds = Rectangle(80, 380, 110, 30)
        Hex.alignmentX = Component.LEFT_ALIGNMENT
        Hex.font = defaultFont
        Hex.isEditable = false
        add(Hex)

        copy = JButton("\uDCCB")
        copy.bounds = Rectangle(200, 380, 40, 30)
        copy.font = defaultFont
        copy.addActionListener(this)
        copy.toolTipText = "Copy to clipboard"
        add(copy)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            copy -> copyToClipboard(Hex.text)
        }
    }

    override fun stateChanged(e: ChangeEvent?) {
        val R = r.value as? Int ?: 0
        val G = g.value as? Int ?: 0
        val B = b.value as? Int ?: 0

        r.background = Color(R, 0, 0)
        g.background = Color(0, G, 0)
        b.background = Color(0, 0, B)

        _colour = Color(R, G, B)
        colourLabel.background = _colour
        val hex = String.format("#%02X%02X%02X", R, G, B) // %02X means format the number as a 2 digit hexadecimal
        Hex.text = hex
    }
}

