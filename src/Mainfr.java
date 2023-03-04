import java.awt.EventQueue;
import jaco.mp3.player.MP3Player;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DarkTable.TableDark;
import ScaledIcon.NoScalingIcon;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.EventDrawer;
import javaswingdev.drawer.DrawerItem;

import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.beans.PropertyChangeEvent;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JSlider;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.File;
//AudioPlayer a = new AudioPlayer();
public class Mainfr extends JFrame {
    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	int x, y,duration=1;
    boolean showp = false;
    ImageIcon im;
    private JPanel contentPane;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mainfr frame = new Mainfr();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //-----------------------------------------
//        Scanner s = null;
//		try {
//			s = new Scanner(new File("filepath"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        ArrayList<String> list = new ArrayList<String>();
//        while (s.hasNext()){
//            list.add(s.next());
//        }
//        s.close();
      
    }

    /**
     * Create the frame.
     *
     * @throws Exception
     */
    public Mainfr() throws Exception {
    
        setUndecorated(true);
        addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
     

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();	
                y = e.getY();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {

                int xx = e.getXOnScreen();
                int yy = e.getYOnScreen();
                setLocation(xx - x, yy - y);

            }
        });
        JPanel panel_3 = new JPanel();
        
 
        panel_3.setBackground(new Color(32, 32, 32));
        panel_3.setVisible(false);
        panel_3.setBounds(0, 82, 206, 329);
//		contentPane.add(panel_3);
		panel_3.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.DARK_GRAY);
        panel_1.setBounds(563, 280, 19, 120);
        contentPane.add(panel_1,BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));
        
        JSlider slider = new JSlider();
        slider.setBackground(Color.DARK_GRAY);
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.setBounds(0, 11, 19, 98);
        slider.setFocusable(false);
        Icon iconn = new ImageIcon("a.gif");
        UIDefaults defaults = UIManager.getDefaults();
        defaults.put("Slider.horizontalThumbIcon", iconn);

        panel_1.add(slider);
//        panel_1.add(slider);
//        VolLab.setVisible(false);
        panel_1.setVisible(false);

	
        panel.setAlignmentY(Component.TOP_ALIGNMENT);
        panel.setBackground(new Color(32, 32, 32));
        panel.setBounds(0, 0, 600, 81);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel miniMize = new JLabel("-");
        miniMize.setForeground(Color.WHITE);
        miniMize.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setExtendedState(JFrame.ICONIFIED);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//				Font f=lblNewLabel_1_1.getFont();
                miniMize.setForeground(Color.DARK_GRAY);
//				lblNewLabel_1_1.setFont(f);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                miniMize.setForeground(Color.white);
            }
        });

        JLabel exit = new JLabel("X");
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLACK);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setForeground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit.setForeground(Color.white);
            }

        });
        exit.setHorizontalTextPosition(SwingConstants.CENTER);
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.setFont(new Font("Tahoma", Font.BOLD, 24));
        exit.setBounds(546, 0, 54, 30);
        panel.add(exit);
        miniMize.setHorizontalTextPosition(SwingConstants.CENTER);
        miniMize.setHorizontalAlignment(SwingConstants.CENTER);
        miniMize.setFont(new Font("Tahoma", Font.BOLD, 24));
        miniMize.setBounds(483, 0, 53, 30);
        panel.add(miniMize);

        JLabel title = new JLabel("Sparky Music Player");
        title.setToolTipText("Spark is the best");
        title.setForeground(Color.WHITE);
        title.setBounds(10, 2, 235, 28);
        title.setAlignmentY(Component.TOP_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Tahoma", Font.BOLD, 15));
        title.setBackground(Color.BLACK);
        panel.add(title);

        JPanel menu1 = new JPanel();
        menu1.setBounds(10, 41, 28, 5);
        panel.add(menu1);

        JPanel menu2 = new JPanel();
        menu2.setBounds(10, 49, 28, 5);
        panel.add(menu2);
        JPanel menu3 = new JPanel();
        menu3.setBounds(10, 57, 28, 5);
        panel.add(menu3);
        JLabel menuLabel = new JLabel("My Music");
        menuLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        menuLabel.setForeground(Color.WHITE);
        menuLabel.setBackground(Color.WHITE);
        menuLabel.setBounds(52, 41, 181, 19);
        panel.add(menuLabel);

        JLabel menuPanel = new JLabel("");
        menuPanel.setToolTipText("Show Menu");
        menuPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                menu1.setBackground(Color.DARK_GRAY);
                menu2.setBackground(Color.DARK_GRAY);
                menu3.setBackground(Color.DARK_GRAY);
                menu1.setForeground(Color.DARK_GRAY);
                menu2.setForeground(Color.DARK_GRAY);
                menu3.setForeground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menu1.setBackground(Color.white);
                menu2.setBackground(Color.white);
                menu3.setBackground(Color.white);
                menu1.setForeground(Color.white);
                menu2.setForeground(Color.white);
                menu3.setForeground(Color.white);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (drawer.isShow()) {
                	drawer.hide();
//                    panel_3.setVisible(true);
//                    menuPanel.setToolTipText("Exit Menu");
//                    showp = true;
//                    tableDark.clearSelection();
//                    tableDark.setFocusable(false);
//                    tableDark.setRowSelectionAllowed(false);
//                 
                } else {
                	drawer.show();
                	//                 
//                	panel_3.setVisible(false);
//                  
//                    menuPanel.setToolTipText("Show Menu");
//                    showp = false;
                }
            }

        });
        menuPanel.setBounds(10, 41, 28, 29);
        panel.add(menuPanel);


        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(new Color(32, 32, 32));
        panel_2.setAlignmentY(0.0f);
        panel_2.setBounds(0, 409, 600, 91);
        contentPane.add(panel_2);

        JLabel currentSong = new JLabel("Now Playing : test Song");
        currentSong.setForeground(Color.WHITE);
        currentSong.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        currentSong.setBackground(Color.BLACK);
        currentSong.setAlignmentY(0.0f);
        currentSong.setAlignmentX(0.5f);
        currentSong.setBounds(20, 0, 370, 28);
        panel_2.add(currentSong);

        JLabel artist = new JLabel("Artist :Spark1ST");
        artist.setForeground(Color.WHITE);
        artist.setFont(new Font("Tahoma", Font.BOLD, 13));
        artist.setBackground(Color.WHITE);
        artist.setBounds(20, 24, 97, 19);
        panel_2.add(artist);
		 NoScalingIcon icon = new NoScalingIcon( new ImageIcon("playb.png") );
		 NoScalingIcon pauseIcon = new NoScalingIcon( new ImageIcon("pauseb.png") );
		 NoScalingIcon prevIcon = new NoScalingIcon( new ImageIcon("prevb.png") );
		 NoScalingIcon nextIcon = new NoScalingIcon( new ImageIcon("nextb.png") );
		 NoScalingIcon volIcon = new NoScalingIcon( new ImageIcon("vol1.png") );
		 NoScalingIcon leftarr = new NoScalingIcon( new ImageIcon("arrow left.png") );
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(20);
        progressBar.setForeground(Color.WHITE);
        progressBar.setBackground(Color.DARK_GRAY);
        progressBar.setBounds(37, 76, 526, 5);
        panel_2.add(progressBar);
        
        JLabel plyPau = new JLabel(icon);
        plyPau.setText("PLAY");
        plyPau.setHorizontalTextPosition(SwingConstants.CENTER);
        plyPau.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel playPanel = new JPanel();
        playPanel.setToolTipText("Play");
        playPanel.setBounds(445, -3, 55, 53);
        playPanel.setBackground(new Color(32, 32, 32));
        panel_2.add(playPanel);
        JPanel nextPanel = new JPanel();
        nextPanel.setToolTipText("Next Song");
        nextPanel.setBounds(500, -3, 55, 53);
        nextPanel.setBackground(new Color(32, 32, 32));
        panel_2.add(nextPanel);
        JPanel prevPanel = new JPanel();
        prevPanel.setToolTipText("Previous Song");
        prevPanel.setBounds(390, -3, 55, 53);
        prevPanel.setBackground(new Color(32, 32, 32));
        panel_2.add(prevPanel);
        plyPau.addMouseListener(new MouseAdapter() {
        File filePath= new File ("af.mp3");
        MP3Player m = new MP3Player(filePath);
            @Override
            public void mouseEntered(MouseEvent e) {
            	playPanel.setBackground(Color.DARK_GRAY);
            	playPanel.setForeground(Color.DARK_GRAY);
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	playPanel.setBackground(new Color(32, 32, 32));    
            	playPanel.setForeground(new Color(32, 32, 32));
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
            	if(plyPau.getText().equals("PAUSE")) {
            		m.pause();
            		plyPau.setText("PLAY");
            		plyPau.setIcon(icon);
            		
            	}
            	else {
//            		String filePath = "af.mp3";
            		plyPau.setText("PAUSE");
            		plyPau.setIcon(pauseIcon);
            		m.play();
            	
            	}
                }
        });
        plyPau.setFont(new Font("Tahoma", Font.PLAIN, 0));
        plyPau.setForeground(Color.WHITE);
        playPanel.add(plyPau);
        
        JLabel prebl = new JLabel(prevIcon);
        prebl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	prevPanel.setBackground(Color.DARK_GRAY);      
            	prevPanel.setForeground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	prevPanel.setBackground(new Color(32, 32, 32));    
            	prevPanel.setForeground(new Color(32, 32, 32));
            }

            @Override
            public void mousePressed(MouseEvent e) {
//            	if(lblNewLabel_5.getText().equals("PAUSE")) {
//            		lblNewLabel_5.setText("PLAY");
//            	}
//            	else {
//            		lblNewLabel_5.setText("PAUSE");
//            	}
                }
        });
        prebl.setHorizontalTextPosition(SwingConstants.CENTER);
        prebl.setHorizontalAlignment(SwingConstants.CENTER);
        prebl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        prebl.setForeground(Color.WHITE);

        prevPanel.add(prebl);
        
        JLabel Nextbl = new JLabel(nextIcon);
        nextPanel.add(Nextbl);
        Nextbl.addMouseListener(new MouseAdapter() {
        	   @Override
               public void mouseEntered(MouseEvent e) {
        		   nextPanel.setBackground(Color.DARK_GRAY);
        		   nextPanel.setForeground(Color.DARK_GRAY);
               }

               @Override
               public void mouseExited(MouseEvent e) {
            	   nextPanel.setBackground(new Color(32, 32, 32));
            	   nextPanel.setForeground(new Color(32, 32, 32));
               }

               @Override
               public void mousePressed(MouseEvent e) {
//               	if(lblNewLabel_5.getText().equals("PAUSE")) {
//               		lblNewLabel_5.setText("PLAY");
//               	}
//               	else {
//               		lblNewLabel_5.setText("PAUSE");
//               	}
                   }
           });
        Nextbl.setHorizontalTextPosition(SwingConstants.CENTER);
        Nextbl.setHorizontalAlignment(SwingConstants.CENTER);
        Nextbl.setForeground(Color.WHITE);
        Nextbl.setFont(new Font("Tahoma", Font.PLAIN, 16));

        
        JLabel songDuration = new JLabel("0:30");
        songDuration.setFont(new Font("Tahoma", Font.PLAIN, 14));
        songDuration.setForeground(Color.WHITE);
        songDuration.setBounds(4, 70, 33, 13);
        panel_2.add(songDuration);
        
        JLabel songTime = new JLabel("3:30");
        songTime.setForeground(Color.WHITE);
        songTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        songTime.setBounds(567, 70, 33, 13);
        panel_2.add(songTime);
        JLabel volLab = new JLabel(volIcon);
        volLab.setText("false");
        JPanel Vol = new JPanel();
        Vol.setToolTipText("Control Volume");
        Vol.addMouseListener(new MouseAdapter() {
       	   @Override
           public void mouseEntered(MouseEvent e) {
       		Vol.setBackground(Color.DARK_GRAY);
       		Vol.setForeground(Color.DARK_GRAY);
           }

           @Override
           public void mouseExited(MouseEvent e) {
        	   Vol.setBackground(new Color(32, 32, 32));
        	   Vol.setForeground(new Color(32, 32, 32));
           }

           @Override
           public void mousePressed(MouseEvent e) {
           	if(volLab.getText().equals("true")) {
           		volLab.setText("false");
           		panel_1.setVisible(false);
//           		VolLab.setVisible(false);

           	}
           	else {
           		volLab.setText("true");
           		panel_1.setVisible(true);
//           		VolLab.setVisible(true);

           	}
               }
       });
        Vol.setBackground(new Color(32, 32, 32));
        Vol.setBounds(555, 10, 35, 28);
        panel_2.add(Vol);
        
        
        volLab.setHorizontalTextPosition(SwingConstants.CENTER);
        volLab.setHorizontalAlignment(SwingConstants.CENTER);
        volLab.setForeground(Color.WHITE);
        volLab.setFont(new Font("Tahoma", Font.PLAIN, 0));
        
        Vol.add(volLab);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(Color.BLACK);
        panel_4.setForeground(Color.BLACK);
        panel_4.setBounds(0, 80, 600, 332);
        contentPane.add(panel_4);
        
    
        new javax.swing.JScrollPane();
        new DarkTable.TableDark();
        DefaultTableModel model = new DefaultTableModel(); 
        
        
    	JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override//---------------------------------------------------------------
			public void mousePressed(MouseEvent e) {//side panel list
				 JList theList = (JList) e.getSource();
			       
			          int index = theList.locationToIndex(e.getPoint());
			          Object o = theList.getModel().getElementAt(index);
			          if (index == 0) {
			            
			          
			          }
			          else if (index==1) {
			        	  
			          }
			          else if (index==2) {
			        	  
			          }
			          else if (index==3) {
			        	  
			          }
			          menuLabel.setText(o.toString());
			}
		});
		list.setFixedCellHeight(80);
		list.setValueIsAdjusting(true);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setForeground(Color.WHITE);
		list.setModel(new AbstractListModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"My Music", "Play Lists", "Recently Played","Settings"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_4.setLayout(null);
		list.setFocusable(false);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);  
		list.setSelectionForeground(Color.GRAY);
		list.setSelectionBackground(Color.DARK_GRAY);
		list.setBackground(new Color(32, 32, 32));
		list.setBounds(0, 0, 206, 377);
		panel_3.add(list);
		tableDark = new DarkTable.TableDark();
		tableDark.setFocusable(false);
		tableDark.setTableHeader(null);
//		tableDark.getTableHeader().setReorderingAllowed(false);
		tableDark.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			    int column = 0;
			    int row = tableDark.getSelectedRow();
			    
//			    row.setBackground(Color.BLACK);
			    String value = tableDark.getModel().getValueAt(row, column).toString();
			    currentSong.setText("Now Playing : "+value);
			    plyPau.setIcon(pauseIcon);
			    plyPau.setText("PAUSE");
			    progressBar.setValue(0);
			    songDuration.setText((progressBar.getValue()*duration/100)+"");
			    songTime.setText("time");
			    
			}
		});

		tableDark.setShowHorizontalLines(false);
		tableDark.setShowVerticalLines(false);
		tableDark.setShowGrid(false);
		tableDark.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDark.setFillsViewportHeight(true);
		scrollPan = new javax.swing.JScrollPane();
		scrollPan.setViewportBorder(null);
		scrollPan.setBounds(0, 0, 600, 332);
		scrollPan.setForeground(Color.BLACK);
		scrollPan.setBackground(Color.BLACK);
		tableDark.fixTable(scrollPan);
	    tableDark.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Song Name","ID"
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
	    

	    
   
//       
//        setLocationRelativeTo(panel_4);
	    scrollPan.setViewportView(tableDark);
	    tableDark.setForeground(Color.BLACK);
	    tableDark.setBackground(Color.BLACK);
	    tableDark.removeColumn(tableDark.getColumnModel().getColumn(1));
	    DrawerItem mm=new DrawerItem("My Music");
	    DrawerItem pl=new DrawerItem("PlayLists");
	    DrawerItem rp=new DrawerItem("Recently Played");
	    DrawerItem set=new DrawerItem("Settings");
	    DrawerItem footer =new DrawerItem("Exit");
	    Header h= new Header();
	    mm.setForeground(Color.white);
	    pl.setForeground(Color.white);
	    rp.setForeground(Color.white);
	    set.setForeground(Color.white);
	    footer.setForeground(Color.white);

	    drawer=Drawer.newDrawer(this)
	    		.closeOnPress(true)
	    		
                .backgroundTransparent(0.3f)
                .leftDrawer(true)
                .enableScroll(true)
                .enableScrollUI(false)
                .headerHeight(160)
                .header(h)
                .space(3)
                .addChild(mm.build())
                .addChild(pl.build())
                .addChild(rp.build())
                .addChild(set.build())
                .addFooter(footer.icon(leftarr).build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int index, DrawerItem item) {
                     if(drawer.isShow()){
                         drawer.hide();
                     }
                     if (item == rp) {
                    	 h.textSetter("Recently Played");
                    	 menuLabel.setText("Recently Played");
                     }
                     else if (item == pl) {
                    	 h.textSetter("Play Lists");
                    	 menuLabel.setText("Play Lists");
                     }
                     else if (item == set) {
                    	 h.textSetter("Settings");
                    	 menuLabel.setText("Settings");
                     }
                     else if (item == mm) {
                    	 h.textSetter("My Music");
                    	 menuLabel.setText("My Music");
                     }
                    }
                })
	    		.build();
	    
        panel_4.add(scrollPan);
        
        DefaultTableModel mode = (DefaultTableModel) tableDark.getModel();
        for (int i = 1; i <= 20; i++) {
            mode.addRow(new Object[]{i,i});
           
        }
        
        //----------------------------------------
        String mmm = tableDark.getModel().getValueAt(1,1).toString();//retrieve data from hidden column
        

      }
    
    private JScrollPane scrollPan;
    private TableDark tableDark;
    private DrawerController drawer;
}
