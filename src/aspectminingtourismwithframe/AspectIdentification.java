


package aspectminingtourismwithframe;

import java.util.ArrayList;

public class AspectIdentification extends javax.swing.JFrame {

    public static ArrayList aspectsidentification=new ArrayList();
    
    public AspectIdentification() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 153, 0));

        jLabel1.setFont(new java.awt.Font("Andalus", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aspect Identification");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel1)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jButton1.setText("Aspect Extraction or Aspect Identification");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("Orientation Finder");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try
        {
            System.out.println("*************************************2********************************************");
            System.out.println("Aspect Extraction or Aspect Identification");
            System.out.println("*********************************************************************************");
            String str=HomePage.str.trim();
            String sp[]=str.trim().split("\n");
            edu.stanford.nlp.tagger.maxent.MaxentTagger ob=new edu.stanford.nlp.tagger.maxent.MaxentTagger(".\\models\\left3words-distsim-wsj-0-18.tagger");
                        
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Temporary Work Start for Aspect Identification~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for(int i=0;i<sp.length;i++)
            {
                String eachreview = sp[i].trim();                
                String ret=ob.tagString(eachreview);
                System.out.println("\nresult is: "+ret);		
                System.out.println("Nouns\n======");
                ArrayList aspectsonly=new ArrayList();
                ArrayList aspectswithcount=new ArrayList();
                int max=1;
                if(ret.contains(" "))
                {
                    String s1[]=ret.trim().split(" ");
                    for(int j=0;j<s1.length;j++)
                    {
                        if(s1[j].contains("/NNPS"))
                        {
                            String noun=s1[j].replaceAll("/NNPS","");
                            System.out.println(noun);
                            if(!(aspectsonly.contains(noun.trim())))
                            {
                                aspectsonly.add(noun.trim());
                                aspectswithcount.add(noun.trim()+"#"+"1");
                            }
                            else
                            {
                                int index=aspectsonly.indexOf(noun.trim());
                                String val[]=aspectswithcount.get(index).toString().trim().split("#");
                                int frequent=Integer.parseInt(val[1].trim())+1;
                                aspectswithcount.set(index, val[0].trim()+"#"+frequent);
                                if(frequent>max)
                                {
                                    max=frequent;
                                }
                            }
                        }
                        else if(s1[j].contains("/NNP"))
                        {
                            String noun=s1[j].replaceAll("/NNP","");
                            System.out.println(noun);
                            if(!(aspectsonly.contains(noun.trim())))
                            {
                                aspectsonly.add(noun.trim());
                                aspectswithcount.add(noun.trim()+"#"+"1");
                            }
                            else
                            {
                                int index=aspectsonly.indexOf(noun.trim());
                                String val[]=aspectswithcount.get(index).toString().trim().split("#");
                                int frequent=Integer.parseInt(val[1].trim())+1;
                                aspectswithcount.set(index, val[0].trim()+"#"+frequent);
                                if(frequent>max)
                                {
                                    max=frequent;
                                }
                            }
                        }
                        else if(s1[j].contains("/NNS"))
                        {
                            String noun=s1[j].replaceAll("/NNS","");
                            System.out.println(noun);
                            if(!(aspectsonly.contains(noun.trim())))
                            {
                                aspectsonly.add(noun.trim());
                                aspectswithcount.add(noun.trim()+"#"+"1");
                            }
                            else
                            {
                                int index=aspectsonly.indexOf(noun.trim());
                                String val[]=aspectswithcount.get(index).toString().trim().split("#");
                                int frequent=Integer.parseInt(val[1].trim())+1;
                                aspectswithcount.set(index, val[0].trim()+"#"+frequent);
                                if(frequent>max)
                                {
                                    max=frequent;
                                }
                            }
                        }
                        else if(s1[j].contains("/NN"))
                        {
                            String noun=s1[j].replaceAll("/NN","");
                            System.out.println(noun);
                            if(!(aspectsonly.contains(noun.trim())))
                            {
                                aspectsonly.add(noun.trim());
                                aspectswithcount.add(noun.trim()+"#"+"1");
                            }
                            else
                            {
                                int index=aspectsonly.indexOf(noun.trim());
                                String val[]=aspectswithcount.get(index).toString().trim().split("#");
                                int frequent=Integer.parseInt(val[1].trim())+1;
                                aspectswithcount.set(index, val[0].trim()+"#"+frequent);
                                if(frequent>max)
                                {
                                    max=frequent;
                                }
                            }
                        }
                    }
                }
                else
                {
                    if(ret.contains("/NNPS"))
                    {
                        String noun=ret.replaceAll("/NNPS","");
                        System.out.println(noun);
                        if(!(aspectsonly.contains(noun.trim())))
                        {
                            aspectsonly.add(noun.trim());
                            aspectswithcount.add(noun.trim()+"#"+"1");
                        }
                        else
                        {
                            int index=aspectsonly.indexOf(noun.trim());
                            String val[]=aspectswithcount.get(index).toString().trim().split("#");
                            int frequent=Integer.parseInt(val[1].trim())+1;
                            aspectswithcount.set(index, val[0].trim()+"#"+frequent);
                            if(frequent>max)
                            {
                                max=frequent;
                            }
                        }
                    }
                    else if(ret.contains("/NNP"))
                    {
                        String noun=ret.replaceAll("/NNP","");
                        System.out.println(noun);
                        if(!(aspectsonly.contains(noun.trim())))
                        {
                            aspectsonly.add(noun.trim());
                            aspectswithcount.add(noun.trim()+"#"+"1");
                        }
                        else
                        {
                            int index=aspectsonly.indexOf(noun.trim());
                            String val[]=aspectswithcount.get(index).toString().trim().split("#");
                            int frequent=Integer.parseInt(val[1].trim())+1;
                            aspectswithcount.set(index, val[0].trim()+"#"+frequent);
                            if(frequent>max)
                            {
                                max=frequent;
                            }
                        }
                    }
                    else if(ret.contains("/NNS"))
                    {
                        String noun=ret.replaceAll("/NNS","");
                        System.out.println(noun);
                        if(!(aspectsonly.contains(noun.trim())))
                        {
                            aspectsonly.add(noun.trim());
                            aspectswithcount.add(noun.trim()+"#"+"1");
                        }
                        else
                        {
                            int index=aspectsonly.indexOf(noun.trim());
                            String val[]=aspectswithcount.get(index).toString().trim().split("#");
                            int frequent=Integer.parseInt(val[1].trim())+1;
                            aspectswithcount.set(index, val[0].trim()+"#"+frequent);
                            if(frequent>max)
                            {
                                max=frequent;
                            }
                        }
                    }
                    else if(ret.contains("/NN"))
                    {
                        String noun=ret.replaceAll("/NN","");
                        System.out.println(noun);
                        if(!(aspectsonly.contains(noun.trim())))
                        {
                            aspectsonly.add(noun.trim());
                            aspectswithcount.add(noun.trim()+"#"+"1");
                        }
                        else
                        {
                            int index=aspectsonly.indexOf(noun.trim());
                            String val[]=aspectswithcount.get(index).toString().trim().split("#");
                            int frequent=Integer.parseInt(val[1].trim())+1;
                            aspectswithcount.set(index, val[0].trim()+"#"+frequent);
                            if(frequent>max)
                            {
                                max=frequent;
                            }
                        }
                    }
                }
                System.out.println("maximum frequent: "+max);
                System.out.println("aspectswithcount: "+aspectswithcount);
                if(!(aspectswithcount.isEmpty()))
                {
                    String s1=aspectswithcount.get(0).toString().trim();
                    String spk1[]=s1.trim().split("#");
                
                    String bestaspect=spk1[0].trim();
                    for(int j=0;j<aspectswithcount.size();j++)
                    {
                        String s=aspectswithcount.get(j).toString().trim();
                        String spk[]=s.trim().split("#");
                        if(spk[1].trim().equals(""+max))
                        {
                            bestaspect=spk[0].trim();
                            break;
                        }
                    }
                    System.out.println("bestaspect: "+bestaspect);
                    aspectsidentification.add(bestaspect.trim()+" --> "+eachreview.trim());
                }
                else
                {
                    System.out.println("bestaspect: "+"-");
                }
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Temporary Work End~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("**********************************************************************************");
            System.out.println("Aspect Identification Results");
            System.out.println("**********************************************************************************");
            String ro="";
            for(int i=0;i<aspectsidentification.size();i++)
            {
                String s=aspectsidentification.get(i).toString().trim();
                System.out.println(s.trim());
                ro=ro+s.trim()+"\n";
            }
            System.out.println("*************************************2********************************************");
            System.out.println();
            String header="**********************************************************************************\n              Aspect Identification Results\n**********************************************************************************\n";
            String footer="**********************************************************************************";
            jTextArea1.setText(header.trim()+"\n"+ro.trim()+"\n"+footer.trim());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        OrientationFinder of=new OrientationFinder();
        of.setTitle("Orientation Finder");
        of.setVisible(true);
        of.setResizable(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AspectIdentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AspectIdentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AspectIdentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AspectIdentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AspectIdentification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
