package courier;

import java.awt.*;
import javax.swing.*;

public class SlipDialog {

    // modal dialog to get courier slip information
    static String[] exitCondition = { "OK", "Cancel" };
    static String   dialogTitle = "Courier Slip Dialog";

    SlipDialog( CourierSlip slip, StringBuffer priority ) {
        getCourierSlip( slip, priority );
    }

    void getCourierSlip( CourierSlip slip, StringBuffer priority ) {
        JPanel      connectionPanel;

        // Create the labels and text fields.
        JLabel     pickupLabel   = new JLabel("Pickup location:", JLabel.LEFT);
        JTextField pickupField   = new JTextField(" ", 24);
        JLabel     destLabel     = new JLabel("Destination:", JLabel.LEFT);
        JTextField destField     = new JTextField("");
        JLabel     itemLabel     = new JLabel("Pickup Item:", JLabel.LEFT);
        JTextField itemField     = new JTextField("");
        JLabel     priorityLabel = new JLabel("Priority:", JLabel.LEFT);
        JTextField priorityField = new JTextField("");

        connectionPanel = new JPanel( false );
        connectionPanel.setLayout( new BoxLayout( connectionPanel,
						  BoxLayout.X_AXIS ) );
        JPanel namePanel = new JPanel( false );
        namePanel.setLayout( new GridLayout( 0, 1 ) );
        namePanel.add( pickupLabel );
        namePanel.add( destLabel );
        namePanel.add( itemLabel );
        namePanel.add( priorityLabel );
        JPanel fieldPanel = new JPanel( false );
        fieldPanel.setLayout( new GridLayout( 0, 1 ) );
        fieldPanel.add( pickupField );
        fieldPanel.add( destField );
        fieldPanel.add( itemField );
        fieldPanel.add( priorityField );
        connectionPanel.add(namePanel);
        connectionPanel.add(fieldPanel);

        if ( JOptionPane.showOptionDialog( null, connectionPanel,
                                        dialogTitle,
                                        JOptionPane.OK_CANCEL_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE,
                                        null, exitCondition,
                                        exitCondition[0]) != 0) {
            // indicate the user cancelled the action
            priority.append( "Cancelled" );
            return;
	}
        slip.setSource( pickupField.getText() );
        slip.setDestination( destField.getText() );
        slip.setPickupItem( itemField.getText() );
        String s = priorityField.getText();
        priority.replace( 0, s.length() + 1 , s );
    }
}

