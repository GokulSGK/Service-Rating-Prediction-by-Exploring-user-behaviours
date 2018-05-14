
package aspectminingtourismwithframe;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class Main {
    public static void main(String[] args) 
    {        
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        try
        {                    
			
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            
            HomePage nc=new HomePage();
            nc.setTitle("Homepage");
            nc.setVisible(true);
            nc.setResizable(false); 
	}
	catch (Exception ex)
	{            
            System.out.println(ex);
	}        
    }
}
