import { Component, OnInit } from "@angular/core";
import { Response, RequestOptions, Headers } from "@angular/http";

import * as _ from "lodash";
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { AuthenticationService } from "app/security/authentication.service";

@Component({
  selector: "app-main-component",
  templateUrl: "./main-component.component.html",
  styleUrls: ["./main-component.component.css"]
})
export class MainComponentComponent implements OnInit {
  vesti: any[];
  kategorije: any[];
  vest: any = {
    naslov: "",
    sadrzaj: "",
    opis: "",
    
  };

  currentPage: number = 0;
  numberOfPages: number = 0;
  size: number = 4;
  naziv: string;
  idKategorije: number;

  ngOnInit(): void {
    this.loadData();
    this.loadKategorije();
  }

  constructor(
    private authenticationService: AuthenticationService,
    private http: HttpClient
  ) {}

  hasRole(role: string): boolean {
    return this.authenticationService.hasRole(role);
  }
  loadData() {
    const params = new HttpParams()
      .set("page", this.currentPage.toString())
      .set("size", this.size.toString());
    this.http.get("api/vesti", { params }).subscribe(data => {
      this.vesti = data["content"] as any;
      this.numberOfPages = data["totalPages"];
      this.reset();
    });
  }
  loadKategorije() {
    this.http.get("api/kategorije").subscribe(data => {
      this.kategorije = data as any;
    });
  }
  loadFilteredData() {
    console.log(this.idKategorije);
    console.log(this.naziv);
    const params = new HttpParams()
      .set("page", "0")
      .set("size", this.size.toString())
      .set("name", this.naziv.toString())
      .set("kategorijaId", this.idKategorije.toString());

    this.http.get("api/vesti/filter", { params }).subscribe(data => {
      console.log(data["content"]);
      this.vesti = data["content"] as any;
      this.numberOfPages = data["totalPages"];
    });
  }
  save() {
    const headers = new HttpHeaders({ "Content-Type": "application/json" });
    if (this.vest.id === undefined) {
      this.http
        .post("api/vesti", JSON.stringify(this.vest), { headers })
        .subscribe(data => {
          console.log(this.vest);
          this.loadData();
        });
    } else {
      this.http
        .put(`api/vesti/${this.vest.id}`, JSON.stringify(this.vest), {
          headers
        })
        .subscribe(data => {
          this.loadData();
        });
    }
  }
  delete(vest: any) {
    this.http.delete(`api/vesti/${vest.id}`).subscribe(data => {
      this.loadData();
    });
  }
  reset() {
    this.vest = {
      naslov: "",
      sadrzaj: "",
      opis: "",
      kategorija: { naziv: "" }
    };
  }
  changePage(x: number) {
    if (
      this.currentPage + x >= 0 &&
      this.currentPage + x < this.numberOfPages
    ) {
      this.currentPage += x;
      this.loadData();
    }
  }
  resetFilter() {
    this.idKategorije = undefined;
    this.naziv = undefined;
    this.loadData();
  }
  isLoggedIn() {
    return this.authenticationService.isLoggedIn();
  }
  edit(v: any) {
    this.vest = v;
  }
  byId(item1: any, item2: any) {
    if (!item1 || !item2) {
      return false;
    }
    return item1.id === item2.id;
  }
}
