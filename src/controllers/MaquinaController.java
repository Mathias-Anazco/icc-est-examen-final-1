package controllers;

import java.util.*;
import models.Maquina;

public class MaquinaController {

    // 🔷 Método A
    public static Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas, int umbral) {
        Stack<Maquina> pila = new Stack<>();
        for (Maquina m : maquinas) {
            if (m.getSubred() > umbral) {
                pila.push(m);
            }
        }
        return pila;
    }

    // 🔷 Método B
    public static TreeSet<Maquina> ordenarPorSubred(Stack<Maquina> pila) {
        Comparator<Maquina> comp = Comparator
            .comparingInt(Maquina::getSubred).reversed()
            .thenComparing(Maquina::getNombre);

        TreeSet<Maquina> treeSet = new TreeSet<>(comp);
        treeSet.addAll(pila);
        return treeSet;
    }

    // 🔷 Método C
    public static Map<Integer, Queue<Maquina>> agruparPorRiesgo(List<Maquina> maquinas) {
        Map<Integer, Queue<Maquina>> mapa = new TreeMap<>();
        for (Maquina m : maquinas) {
            int riesgo = m.getRiesgo();
            mapa.computeIfAbsent(riesgo, k -> new LinkedList<>()).add(m);
        }
        return mapa;
    }

    // 🔷 Método D
    public static Stack<Maquina> explotarGrupo(Map<Integer, Queue<Maquina>> mapa) {
        int maxCantidad = 0;
        int maxRiesgo = 0;

        for (Map.Entry<Integer, Queue<Maquina>> entry : mapa.entrySet()) {
            int cantidad = entry.getValue().size();
            int riesgo = entry.getKey();

            if (cantidad > maxCantidad || (cantidad == maxCantidad && riesgo > maxRiesgo)) {
                maxCantidad = cantidad;
                maxRiesgo = riesgo;
            }
        }

        Queue<Maquina> grupoObjetivo = mapa.get(maxRiesgo);
        Stack<Maquina> pila = new Stack<>();
        for (Maquina m : grupoObjetivo) {
            pila.push(m);
        }
        Collections.reverse(pila);
        return pila;
    }
}
