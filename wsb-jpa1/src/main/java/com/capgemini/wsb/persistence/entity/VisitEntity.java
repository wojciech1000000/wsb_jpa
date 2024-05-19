package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Relacja jednostronna od strony rodzica
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

	//Relacja jednostronna od strony rodzica
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

	//Relacja jednostronna od strony rodzica
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "medicalTreatment_id")
	private MedicalTreatmentEntity medicalTreatment;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

    public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	
}
