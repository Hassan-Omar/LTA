
package example;

import com.fym.lta.ui.Utilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.ActionMap;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public final class MainPanel extends JPanel {
  private MainPanel() {
    super(new BorderLayout());
    
      Utilities.convertTOBase2(199999990);
      
      
    String[] columnNames = {"Screens", "Permission"};
    Object[][] data = {
      {"owner" }, {"group" }, {"other" }
    };
    TableModel model = new DefaultTableModel(data, columnNames) {
      @Override public Class<?> getColumnClass(int column) {
        return getValueAt(0, column).getClass();
      }
    };
    JTable table = new JTable(model) {
      @Override public void updateUI() {
        super.updateUI();
        getColumnModel().getColumn(1).setCellRenderer(new CheckBoxesRenderer());
        getColumnModel().getColumn(1).setCellEditor(new CheckBoxesEditor());
      }
    };
    table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

 
    add(new JScrollPane(table));
    setPreferredSize(new Dimension(320, 240));
  }

  public static void main(String... args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGui();
      }
    });
  }

  public static void createAndShowGui() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
      ex.printStackTrace();
    }
    JFrame frame = new JFrame("CheckBoxesInTableCell");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.getContentPane().add(new MainPanel());
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}

class CheckBoxesPanel extends JPanel {
  // set the color black and status of check box true 
  private static final Color BGC = new Color(0x0, true);
  // we need only 4 , this String Array of titles 
  protected final String[] titles = {"View", "Delete", "Insert","Update"};
  // now we need to list our check box 
  protected final List<JCheckBox> buttons = new ArrayList<>(titles.length);

  @Override public void updateUI() {
    super.updateUI();
    setOpaque(false);
    setBackground(BGC);
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    EventQueue.invokeLater(() -> initButtons());
  }

  private void initButtons() {
    removeAll();
    // clear old checkboxes 
    buttons.clear();
    // loop to add new checkboxes one by one 
    for (String t: titles) {
      JCheckBox b = makeCheckBox(t);
      buttons.add(b);
      add(b);
      add(Box.createHorizontalStrut(5));
    }
  }
  // method to create checkbox 
  private static JCheckBox makeCheckBox(String title) {
    JCheckBox b = new JCheckBox(title);
    b.setOpaque(false);
    b.setFocusable(false);
    b.setRolloverEnabled(false);
    b.setBackground(BGC);
    return b;
  }
 // this only to keep the selected checkbox
  // if we  comment this part when we move to select the row no i all the rows <i will be cleared
  protected void updateButtons(Object v) {
    initButtons();
    Integer i = v instanceof Integer ? (Integer) v : 0;
    buttons.get(0).setSelected((i & (1 << 3)) != 0);
    buttons.get(1).setSelected((i & (1 << 2)) != 0);
    buttons.get(2).setSelected((i & (1 << 1)) != 0);
    buttons.get(3).setSelected((i & (1 << 0)) != 0);
  }
}

class CheckBoxesRenderer extends CheckBoxesPanel implements TableCellRenderer {
  @Override public void updateUI() {
    super.updateUI();
    setName("Table.cellRenderer");
  }

  @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    updateButtons(value);
    return this;
  }
  // public static class UIResource extends CheckBoxesRenderer implements UIResource {}
}
 

class CheckBoxesEditor extends AbstractCellEditor implements TableCellEditor {
  private final CheckBoxesPanel panel = new CheckBoxesPanel() {
    @Override public void updateUI() {
      super.updateUI();
      EventQueue.invokeLater(() -> {
        ActionMap am = getActionMap();
        for (int i = 0; i < buttons.size(); i++) {
          String t = titles[i];
          am.put(t, new AbstractAction(t) {
            @Override public void actionPerformed(ActionEvent e) {
              buttons.stream()
                .filter(b -> b.getText().equals(t))
                .findFirst()
                .ifPresent(JCheckBox::doClick);
              fireEditingStopped();
            }
          });
        }
        InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), titles[0]);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), titles[1]);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), titles[2]);
      });
    }
  };

  @Override public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    panel.updateButtons(value);
    return panel;
  }

  @Override public Object getCellEditorValue() {
    int i = 0;
    
    i = panel.buttons.get(0).isSelected() ? 1 << 3 | i : i;
    i = panel.buttons.get(1).isSelected() ? 1 << 2 | i : i;
    i = panel.buttons.get(2).isSelected() ? 1 << 1 | i : i;
    i = panel.buttons.get(3).isSelected() ? 1 << 0 | i : i;

    return i;
  }
}
