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
import java.awt.event.*
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


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener, ChangeListener {

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
        r.addKeyListener(this)
        r.addChangeListener(this)
        add(r)

        gLabel = JLabel("G")
        gLabel.bounds = Rectangle(40, 300, 30, 30)
        gLabel.font = defaultFont
        add(gLabel)

        g = JSpinner(SpinnerNumberModel(255, 0, 255, 1))
        g.bounds = Rectangle(70, 300, 80, 30)
        g.font = defaultFont
        g.addKeyListener(this)
        g.addChangeListener(this)
        add(g)

        bLabel = JLabel("B")
        bLabel.bounds = Rectangle(40, 340, 30, 30)
        bLabel.font = defaultFont
        add(bLabel)

        b = JSpinner(SpinnerNumberModel(255, 0, 255, 1))
        b.bounds = Rectangle(70, 340, 80, 30)
        b.font = defaultFont
        b.addKeyListener(this)
        b.addChangeListener(this)
        add(b)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {

        }
    }

    override fun keyTyped(e: KeyEvent?) {
        
    }

    override fun keyPressed(e: KeyEvent?) {
        e?.consume()
    }

    override fun keyReleased(e: KeyEvent?) {
        e?.consume()
    }

    override fun stateChanged(e: ChangeEvent?) {

    }

}

