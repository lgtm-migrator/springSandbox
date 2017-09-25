import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Player } from '../player';

@Component({
    selector: 'app-player-form',
    templateUrl: './player-form.component.html',
    styleUrls: ['./player-form.component.css']
})
export class PlayerFormComponent implements OnInit {

    countries = [];
    @Input() player: Player;
    @Output() newPlayer = new EventEmitter<Player>();

    constructor(private _http: Http) {

    }

    ngOnInit() {
        this.getCountries().subscribe(data => {
            this.countries = data;
        });
        this.player = new Player('', '', '', '');
    }

    /**
     * should be in a service !
     */
    getCountries(): Observable<any> {
        return this._http.get('http://vbl-dva-xubuntu15.dev.gnc:10600/api/v1/countries')
            .map((result: Response) => result.json())
            .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
    }

    addNewPlayer() {
        this.player = new Player('', '', '', '');
    }

    onSubmit() {
        this.newPlayer.emit(this.player);
        this.player = new Player('', '', '', '');
    }

}
