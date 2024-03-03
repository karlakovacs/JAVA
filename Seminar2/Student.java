import java.util.Arrays;

public class Student {
    int idStudent;
    String nume;
    String grupa;
    int anul;
    Nota[] note;

    // am folosit generate constructor pentru toate in afara de note
    public Student(int idStudent, String nume, String grupa, int anul) {
        this.idStudent = idStudent;
        this.nume = nume;
        this.grupa = grupa;
        this.anul = anul;
        // comportament recomandat in cazul lucrului cu vectori
        this.note = new Nota[0];
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public int getAnul() {
        return anul;
    }

    public void setAnul(int anul) {
        this.anul = anul;
    }

    public Nota[] getNote() {
        return note;
    }

    public void add(Nota nota) {
        for (var notaExistenta : note) {
            if (nota.getNumeDisciplina().equals(notaExistenta.getNumeDisciplina())) {
                notaExistenta.setNota(nota.getNota());
                return;
            }
        }

        note = Arrays.copyOf(note, note.length + 1);
        note[note.length - 1] = nota;
    }

    @Override
    public String toString() { // la toString punem si pentru note
        return "Student{" +
                "idStudent=" + idStudent +
                ", nume='" + nume + '\'' +
                ", grupa='" + grupa + '\'' +
                ", anul=" + anul +
                ", note=" + Arrays.toString(note) +
                '}';
    }
}
