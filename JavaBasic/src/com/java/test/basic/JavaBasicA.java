package com.java.test.basic;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaBasicA {
	public static void main (String[] args) throws IOException {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.print("Masukkan jumlah mahasiswa : ");
		int n = reader.nextInt();
		System.out.println("");
		
		DataNilaiMahasiswa[] data = new DataNilaiMahasiswa[n];
		int countMahasiswaLulus=0;
		
		for (int i=0; i<n; i++) {
			System.out.println("Data Mahasiswa ke-"+(i+1));
			System.out.println("---------------------------");
			DataNilaiMahasiswa temp = new DataNilaiMahasiswa();
			System.out.print("Masukkan NIM : ");
			temp.setNim(reader.next());
			System.out.print("Masukkan Nama : ");
			temp.setNama(reader.next());
			
			System.out.print("Masukkan Nilai Kehadiran : ");
			int kehadiran = reader.nextInt();
			System.out.print("Masukkan Nilai Midtest : ");
			int midtest = reader.nextInt();
			System.out.print("Masukkan Nilai UAS : ");
			int uas = reader.nextInt();
			
			double nilaiAkhir = 0.2*kehadiran + 0.4*midtest + 0.4*uas;
			char grade;
			
			if (nilaiAkhir >= 85) {
				grade = 'A';
				countMahasiswaLulus++;
			}
			else if (nilaiAkhir >= 76) {
				grade = 'B';
				countMahasiswaLulus++;
			}
			else if (nilaiAkhir >= 61) {
				grade = 'C';
				countMahasiswaLulus++;
			}
			else if (nilaiAkhir >= 46)
				grade = 'D';
			else
				grade = 'E';
			
			temp.setNilaiAkhir(nilaiAkhir);
			temp.setGrade(grade);
			
			data[i]=temp;
			System.out.println("");
			
		}
		reader.close();
		
		List<String> lines = new ArrayList<String>();
		
		lines.add("No. NIM Nama NilaiAkhir Grade");
		lines.add("==============================");
		for (int j=0; j<data.length; j++) {
			lines.add((j+1)+". "+data[j].getNim()+" "+data[j].getNama()+" "+data[j].getNilaiAkhir()+" "+data[j].getGrade());
		}
		lines.add("==============================");
		lines.add("Jumlah Mahasiswa : " + data.length);
		lines.add("Jumlah Mahasiswa yg Lulus : " + countMahasiswaLulus);
		lines.add("Jumlah Mahasiswa yg Tidak Lulus : " + (data.length - countMahasiswaLulus));
		
		for(String print : lines) {
            System.out.println(print);
        }
		
		Path file = Paths.get("mahasiswa.nilai");
		Files.write(file, lines, Charset.forName("UTF-8"));
	}
}
