import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-vest-detalj',
  templateUrl: './vest-detalj.component.html',
  styleUrls: ['./vest-detalj.component.css']
})
export class VestDetaljComponent implements OnInit {
  id: number;
  private sub: any;
  vest: any = {};
  isDataAvailable: boolean;

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      this.id = +params['vestId']; // (+) konvertuje string 'id' u broj
      //id postavljamo kao path parametar pomocu interpolacije stringa
      this.http.get(`/api/vesti/${this.id}`).subscribe(
       //koristimo arrow funkciju da bismo imali leksicki
       //opseg this objekata
       (res) => {
         this.vest=res as any;
         this.isDataAvailable = true;
       }
     );
   });
  }

}
