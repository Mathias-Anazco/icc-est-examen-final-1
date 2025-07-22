package models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Maquina {
    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred;
    private int riesgo;

    public Maquina(String paramString1, String paramString2, List<Integer> paramList) {
        this.nombre = paramString1;
        this.ip = paramString2;
        this.codigos = paramList;
        this.riesgo = calcularRiesgo();
        this.subred = calcularSubred();
    }

    private int calcularSubred() {
        String[] arrayOfString = this.ip.split("\\.");
        return Integer.parseInt(arrayOfString[2]);
    }

    private int calcularRiesgo() {
        int i = 0;
        for (Iterator<Integer> iterator = this.codigos.iterator(); iterator.hasNext(); ) {
            int j = ((Integer) iterator.next()).intValue();
            if (j % 5 == 0)
                i += j;
        }
        HashSet<Character> hashSet = new HashSet();
        for (char c : this.nombre.toCharArray()) {
            if (c != ' ')
                hashSet.add(Character.valueOf(c));
        }
        return i * hashSet.size();
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getIp() {
        return this.ip;
    }

    public List<Integer> getCodigos() {
        return this.codigos;
    }

    public int getSubred() {
        return this.subred;
    }

    public int getRiesgo() {
        return this.riesgo;
    }

    public String toString() {
        return this.nombre + " - Subred: " + this.nombre + " - Riesgo: " + this.subred;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject)
            return true;
        if (!(paramObject instanceof Maquina))
            return false;
        Maquina maquina = (Maquina) paramObject;
        return (this.subred == maquina.subred && Objects.equals(this.nombre, maquina.nombre));
    }

    public int hashCode() {
        return Objects.hash(new Object[] { this.nombre, Integer.valueOf(this.subred) });
    }
}
