 import java.awt.Color;  
 import java.awt.Font;  
 import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;  

public class HintText extends JTextField implements FocusListener {  
   
	private final String hint;
	Font gainFont = new Font("Tahoma", Font.PLAIN, 11);  
	Font lostFont = new Font("Tahoma", Font.ITALIC, 11); 
  
   public HintText(final String hint) {  
	   this.hint = hint;
	   setText(hint);  
	   setFont(lostFont);  
	   setForeground(Color.GRAY);
	   super.addFocusListener(this);
   }
 
    	 @Override  
    	 public void focusGained(FocusEvent e) {  
    		 if (getText().equals(hint)) {  
    			 	setText("");  
    			 	setFont(gainFont);  
    		 } else {  
    			 	setText(getText());  
    			 	setFont(gainFont);  
         }  
       }  
   
    	 @Override  
    	 public void focusLost(FocusEvent e) {  
    		 if (getText().equals(this.hint)|| getText().length()==0) {  
    			 setText(hint);  
    			 setFont(lostFont);  
    			 setForeground(Color.GRAY);  
    		 } else {  
    			 setText(getText());  
    			 setFont(gainFont);  
    			 setForeground(Color.BLACK);  
         }  
       }
    
}  
