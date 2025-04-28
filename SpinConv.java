import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinConv extends JFrame implements ChangeListener{
    private JSpinner milesSpinner;
    private JTextField kmField;
    private JLabel milesLabel;
    private JLabel kmLabel;

    SpinConv() {
        int initMiles;
        int minMiles;
        int maxMiles;
        int stepVal;

        initMiles = 0;
        minMiles = 0;
        maxMiles = 200;
        stepVal = 25;

        GridBagConstraints layoutConst = null;

        SpinnerNumberModel spinnerModel = null;

        setTitle("Miles to kilometers converter");

        milesLabel = new JLabel("Select distance (miles):");
        kmLabel = new JLabel("Distance (km):");

        spinnerModel = new SpinnerNumberModel(initMiles, minMiles, maxMiles, stepVal);
        milesSpinner = new JSpinner(spinnerModel);
        milesSpinner.addChangeListener(this);

        kmField = new JTextField(15);
        kmField.setEditable(false);
        kmField.setText("0");

        setLayout(new GridBagLayout());

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        add(milesLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(milesSpinner, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        add(kmLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        add(kmField, layoutConst);
    }

    @Override
    public void stateChanged(ChangeEvent event) {
        Integer milesInput;
        milesInput = (Integer) milesSpinner.getValue();

        switch (milesInput) {
            case 0:
                kmField.setText("0");
                break;

            case 25:
                kmField.setText("40");
                break;

            case 50:
                kmField.setText("80");
                break;

            case 75:
                kmField.setText("120");
                break;

            case 100:
                kmField.setText("160");
                break;

            case 125:
                kmField.setText("200");
                break;

            case 150:
                kmField.setText("240");
                break;

            case 175:
                kmField.setText("280");
                break;

            case 200:
                kmField.setText("320");
                break;

            default:
                kmField.setText("Out of range!");
        }
    }
    public static void main(String[] args) {
        SpinConv myFrame = new SpinConv();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}