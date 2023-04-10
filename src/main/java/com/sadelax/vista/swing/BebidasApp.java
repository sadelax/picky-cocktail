package com.sadelax.vista.swing;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sadelax.modelo.Bebida;
import com.sadelax.persistencia.BebidaDao;

// no usar todavía por favor gracias xd
//@Component
public class BebidasApp {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private static List<Bebida> bebidas = new ArrayList<>();

    @Autowired
    private BebidaDao dao;

    private static JFrame frame;

    @PostConstruct
    public void init() {
        // Aquí puedes inicializar tu lista de bebidas con los datos de la base de datos
        bebidas = dao.findAll();

        // Crea la primera ventana
        crearVentana1();
    }

    public static void crearVentana1() {
        // Crea los componentes de la ventana
        JLabel pregunta = new JLabel("¿Qué te apetece? (elige al menos 1)");
        JCheckBox dulce = new JCheckBox("Dulce");
        JCheckBox salado = new JCheckBox("Salado");
        JCheckBox amargo = new JCheckBox("Amargo");
        JCheckBox cafe = new JCheckBox("Café");
        JCheckBox afrutado = new JCheckBox("Afrutado");
        JCheckBox sinAzucar = new JCheckBox("Sin azúcar");
        JCheckBox cocaCola = new JCheckBox("Coca-cola");
        JCheckBox soda = new JCheckBox("Soda");
        JCheckBox veraniego = new JCheckBox("Veraniego");
        JCheckBox burbujeante = new JCheckBox("Burbujeante");
        JCheckBox elegante = new JCheckBox("Elegante");
        JCheckBox clasico = new JCheckBox("Clásico");
        JCheckBox tiki = new JCheckBox("Tiki");
        JButton continuar = new JButton("Continuar");

        // Agrega los componentes a un panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3));
        panel.add(pregunta);
        panel.add(dulce);
        panel.add(salado);
        panel.add(amargo);
        panel.add(cafe);
        panel.add(afrutado);
        panel.add(sinAzucar);
        panel.add(cocaCola);
        panel.add(soda);
        panel.add(veraniego);
        panel.add(burbujeante);
        panel.add(elegante);
        panel.add(clasico);
        panel.add(tiki);
        panel.add(continuar);

        // Crea la ventana y agrega el panel
        frame = new JFrame("BebidasApp - Pantalla 1");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        // Agrega un ActionListener para los botones
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene los tags seleccionados
                List<String> tags = new ArrayList<>();
                if (dulce.isSelected()) {
                    tags.add("dulce");
                }
                if (salado.isSelected()) {
                    tags.add("salado");
                }
                if (amargo.isSelected()) {
                    tags.add("amargo");
                }
                if (cafe.isSelected()) {
                    tags.add("café");
                }
                if (afrutado.isSelected()) {
                    tags.add("afrutado");
                }
                if (sinAzucar.isSelected()) {
                    tags.add("sin azúcar");
                }
                if (cocaCola.isSelected()) {
                    tags.add("Coca-cola");
                }
                if (soda.isSelected()) {
                    tags.add("soda");
                }
                if (veraniego.isSelected()) {
                    tags.add("veraniego");
                }
                if (burbujeante.isSelected()) {
                    tags.add("burbujeante");
                }
                if (elegante.isSelected()) {
                    tags.add("elegante");
                }
                if (clasico.isSelected()) {
                    tags.add("clásico");
                }
                if (tiki.isSelected()) {
                    tags.add("tiki");
                }
                
                // Filtra las bebidas por los tags seleccionados al pulsar el botón "Continuar"
                if (e.getSource() == continuar) {
                    List<Bebida> bebidasFiltradas = filtrarBebidasPorTags(tags);
                    System.out.println(bebidasFiltradas);
                    // ...
                }
            }
        };

        // Agrega el ActionListener a los botones
        dulce.addActionListener(listener);
        salado.addActionListener(listener);
        amargo.addActionListener(listener);
        cafe.addActionListener(listener);
        afrutado.addActionListener(listener);
        sinAzucar.addActionListener(listener);
        cocaCola.addActionListener(listener);
        soda.addActionListener(listener);
        veraniego.addActionListener(listener);
        burbujeante.addActionListener(listener);
        elegante.addActionListener(listener);
        clasico.addActionListener(listener);
        tiki.addActionListener(listener);
        continuar.addActionListener(listener);

        // Hace visible la ventana
        frame.setVisible(true);
    }

//    private static List<Bebida> filtrarBebidasPorTags(List<String> tags) {
//        List<Bebida> bebidasFiltradas = new ArrayList<>();
//        for (Bebida bebida : bebidas) {
//            boolean contieneTags = true;
//            for (String tag : tags) {
//                if (!bebida.getTags().contains(tag)) {
//                    contieneTags = false;
//                    break;
//                }
//            }
//            if (contieneTags && bebidasFiltradas != null) {
//                bebidasFiltradas.add(bebida);
//            }
//        }
//        return bebidasFiltradas;
//    }

    private static List<String> obtenerTags(Bebida bebida) {
        String tags = bebida.getTags();
        if (tags == null || tags.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(tags.split(",\\s*"));
    }

    
    private static List<Bebida> filtrarBebidasPorTags(List<String> tags) {
    	int contador = 0;
        List<Bebida> bebidasFiltradas = new ArrayList<>();
        for (Bebida bebida : bebidas) {
            List<String> bebidaTags = obtenerTags(bebida);
            if (bebidaTags != null && bebidaTags.stream().anyMatch(tags::contains)) {
                bebidasFiltradas.add(bebida);
                contador++;
            }
        }
        System.out.println(contador + " rows returned");
        return bebidasFiltradas;
    }

    
    private static void crearVentana2(List<Bebida> bebidas) {
        // Crea los componentes de la ventana
        JLabel titulo = new JLabel("Estas son las bebidas que te recomendamos:");
        JList<Bebida> listaBebidas = new JList<>(bebidas.toArray(new Bebida[0]));
        JButton volver = new JButton("Volver");

        // Agrega los componentes a un panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(titulo, BorderLayout.NORTH);
        panel.add(listaBebidas, BorderLayout.CENTER);
        panel.add(volver, BorderLayout.SOUTH);

        // Crea la ventana y agrega el panel
        JFrame frame2 = new JFrame("BebidasApp - Pantalla 2");
        frame2.setSize(WIDTH, HEIGHT);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.add(panel);

        // Agrega un ActionListener al botón
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana 2 y vuelve a la ventana 1
                frame2.dispose();
                crearVentana1();
            }
        });

        // Hace visible la ventana
        frame2.setVisible(true);
    }
}

