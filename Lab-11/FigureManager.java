import java.util.*;

class FigureManager {
    Figure[] figures;
    final String[] types = new String[] { "Triangle", "Rectangle", "Rhombus" };

    FigureManager(Figure[] figures) {
        this.figures = figures;
    }

    // Count Figures by Type
    void countFigures() {
        Map<String, Integer> m = new HashMap<String, Integer>();

        for (String type : types) {
            m.put(type, 0);
        }

        for (Figure f : figures) {
            String type = f.getName();
            m.put(type, m.get(type) + 1);
        }

        System.out.println("Figure counts:");
        for (String type : types) {
            String suffix = (type.equals("Rhombus")) ? "es" : "s";
            System.out.println(type + suffix + ": " + m.get(type));
        }
    }

    // Find Largest Areas
    void findLargestAreas() {
        Map<String, Double> m = new HashMap<String, Double>();

        for (String type : types) {
            m.put(type, -1.0);
        }

        for (Figure f : figures) {
            String type = f.getName();
            double area = f.getArea();
            if (m.get(type) < area) {
                m.put(type, area);
            }
        }

        System.out.println("Largest areas:");
        for (String type : types) {
            System.out.println(type + ": " + m.get(type));
        }
    }

    // Count Figures by Area
    void countFiguresByArea() {
        Map<Double, Integer> m = new HashMap<Double, Integer>();

        for (Figure f : figures) {
            double area = f.getArea();
            if (!m.containsKey(area)) {
                m.put(area, 0);
            }
            m.put(area, m.get(area) + 1);
        }

        System.out.println("Figures with area 20.0: " + ((m.containsKey(20.0)) ? m.get(20.0) : 0));
        System.out.println("Figures with area 30.0: " + ((m.containsKey(30.0)) ? m.get(30.0) : 0));
    }

    // Replace Figures Based on Precedence
    void replaceFigures() {
        Map<Double, Figure> m = new HashMap<Double, Figure>();

        for (Figure f : figures) {
            double area = f.getArea();
            String type = f.getName();
            if (m.containsKey(area)) {
                String existing = m.get(area).getName();
                if (type.equals("Triangle") && existing.equals("Triangle")) {
                    m.put(area, f);
                }
                else if (type.equals("Rectangle") && !existing.equals("Rhombus")) {
                    m.put(area, f);
                }
                else if (type.equals("Rhombus")) {
                    m.put(area, f);
                }
            }
            else {
                m.put(area, f);
            }
        }

        System.out.println("Figure with area 20.0: " + ((m.containsKey(20.0)) ? m.get(20.0).getName() : "Key not present."));
        System.out.println("Figure with area 30.0: " + ((m.containsKey(30.0)) ? m.get(30.0).getName() : "Key not present."));
    }

    // Calculate Average Areas by Figure Type
    void calculateAverageAreas() {
        Map<String, Double> areas = new HashMap<String, Double>();
        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (String type : types) {
            counts.put(type, 0);
            areas.put(type, 0.0);
        }

        for (Figure f : figures) {
            String type = f.getName();
            counts.put(type, counts.get(type) + 1);
            areas.put(type, areas.get(type) + f.getArea());
        }

        System.out.println("Average areas:");
        for (String type : types) {
            if (counts.get(type) > 0) {
                double averageArea = areas.get(type) / counts.get(type);
                System.out.println(type + ": " + averageArea);
            }
        }
    }
}
