package models;
import java.util.*;

public class Maquina {
    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred;
    private int riesgo;
<<<<<<< HEAD
    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public List<Integer> getCodigos() {
        return codigos;
    }
    public void setCodigos(List<Integer> codigos) {
        this.codigos = codigos;
    }
    public int getSubred() {
        return subred;
    }
    public void setSubred(int subred) {
        this.subred = subred;
    }
    public int getRiesgo() {
        return riesgo;
    }
    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }

    private int calcularSubred(){

        return 0;
    }
    private int calcularRiesgo(){
        return 0;
    }
    @Override
    public String toString() {
        return "Maquina [nombre=" + nombre + ", ip=" + ip + ", codigos=" + codigos + ", subred=" + subred + ", riesgo="
                + riesgo + "]";
    }

    

=======

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
>>>>>>> e2e1633da141c271390fc5f4c140a0c8bec864af
}
