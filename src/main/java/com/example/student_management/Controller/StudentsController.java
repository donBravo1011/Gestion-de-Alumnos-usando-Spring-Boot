package com.example.student_management.Controller;

import com.example.student_management.Model.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/alumnos")
public class StudentsController {

    public List<Alumno> alumnos = new ArrayList<>(Arrays.asList(
            new Alumno(123, "Miguel Bravo", "mbc2003@gmail.com", 21, 5),
            new Alumno(456, "Juan Antonio", "Chiki@gmail.com", 22, 4),
            new Alumno(789, "Paula Cortes", "Cortes10@gmail.com", 20, 3),
            new Alumno(333, "Maria Raquel", "RaquelNurse@gmail.com", 40, 6)
    ));

    @GetMapping
    public List<Alumno> getAlumnos(){
        return alumnos;
    }

    @GetMapping("/{email}")
    public Alumno getAlumno(@PathVariable String email){
        for(Alumno a:alumnos){
            if(a.getEmail().equalsIgnoreCase(email)){
                return a;
            }
        }
        return null;
    }

    @PostMapping
    public Alumno postAlumno(@RequestBody Alumno a){
        alumnos.add(a);
        return a;
    }

    @PutMapping
    public Alumno putAlumno(@RequestBody Alumno alumno){
        for(Alumno a:alumnos){
            if(a.getId()==alumno.getId()){
                a.setCurso(alumno.getCurso());
                a.setEmail(alumno.getEmail());
                a.setEdad(alumno.getEdad());
                a.setNombre(alumno.getNombre());
                return a;
            }
        }
        return null;
    }

    @PatchMapping
    public Alumno patchAlumno(@RequestBody Alumno alumno){
        for(Alumno a:alumnos){
            if(a.getId()==alumno.getId()){
                if(a.getEmail() != null){
                    a.setEmail(alumno.getEmail());
                }
                if(a.getNombre() != null){
                    a.setNombre(alumno.getNombre());
                }
                if(a.getEdad() != 0){
                    a.setEdad(alumno.getEdad());
                }
                if(a.getCurso() != 0){
                    a.setCurso(alumno.getCurso());
                }
                return a;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Alumno patchAlumno(@PathVariable int id){
        for(Alumno a:alumnos){
            if(a.getId()==id){
                alumnos.remove(a);
                return a;
            }
        }
        return null;
    }

}


