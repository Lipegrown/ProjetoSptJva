
package classes;

import java.sql.Date;


public class Calculo {
    
    public int id_pagMensal, id_Funcionario;
    public Date periodo;
    public double salario;

    public int getId_pagMensal() {
        return id_pagMensal;
    }

    public void setId_pagMensal(int id_pagMensal) {
        this.id_pagMensal = id_pagMensal;
    }

    public int getId_Funcionario() {
        return id_Funcionario;
    }

    public void setId_Funcionario(int id_Funcionario) {
        this.id_Funcionario = id_Funcionario;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Calculo() {
    }

    public Calculo(int id_pagMensal, int id_Funcionario, Date periodo, double salario) {
        this.id_pagMensal = id_pagMensal;
        this.id_Funcionario = id_Funcionario;
        this.periodo = periodo;
        this.salario = salario;
    }
    
    
}
