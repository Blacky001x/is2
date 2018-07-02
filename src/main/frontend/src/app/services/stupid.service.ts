import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Headers, RequestOptions, RequestOptionsArgs} from "@angular/http";

@Injectable()
export class StupidService {

  url1 = 'http://localhost:8080/nece';
  url2 = 'http://localhost:8080/lool';
  url3 = 'http://localhost:8080/hgfkl';
  url4 = 'http://localhost:8080/test';

  constructor(private _http: HttpClient) { }

  m1() {
    console.log("COOKIEEEEEEE");
    console.log(document.cookie);
    // var headers = new Headers();
    // headers.append("Content-Type", 'application/json');
    // let options = new RequestOptions({ headers: headers, withCredentials: true });



    return this._http.get(this.url1, { withCredentials:true } );
  }

  m2() {

    console.log("COOKIEEEEEEE");
    console.log(document.cookie);
    var headers = new Headers();
    headers.append("Content-Type", 'application/json');
    let options = new RequestOptions({ headers: headers, withCredentials: true });

    return this._http.get(this.url2, { withCredentials: true });
  }

  m3() {
    console.log("COOKIEEEEEEE");
    console.log(document.cookie);
    var headers = new Headers();
    headers.append("Content-Type", 'application/json');
    let options = new RequestOptions({ headers: headers, withCredentials: true });


    return this._http.get(this.url3, { withCredentials:true });
  }

  m4() {
    console.log('ok, testing service');
    return this._http.get(this.url4, { withCredentials: true });
  }
}
