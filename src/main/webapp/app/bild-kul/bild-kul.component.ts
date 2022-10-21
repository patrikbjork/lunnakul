import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'jhi-bild-kul',
  templateUrl: './bild-kul.component.html',
  styleUrls: ['./bild-kul.component.scss']
})
export class BildKulComponent /*implements OnInit*/ {

  fileName = '';
  ascii: string = '';

  constructor(private http: HttpClient) {}

  onFileSelected(event: any) {
    const file:File = event.target.files[0];

    if (file) {

      this.fileName = file.name;

      const formData = new FormData();

      formData.append("kulBild", file);

      const upload$ = this.http.post("/api/bild-kul-upload", formData, {responseType: "text"});

      upload$.subscribe(value => this.ascii = value);
    }
  }

}
