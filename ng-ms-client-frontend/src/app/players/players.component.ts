import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { PlayersTableComponent } from './player-table/player-table.component';
import { PlayerFormComponent } from './player-form/player-form.component';
import { Player } from './player';

@Component({
    selector: 'app-player-page',
    templateUrl: './players.component.html',
    styleUrls: ['./players.component.css']
})
export class PlayersPageComponent implements OnInit {

    players: Player[] = [];
    player: Player;

    constructor(private _http: Http) {

    }

    ngOnInit() {
        this.getAllPlayers().subscribe(data => {
            this.players = data;
        });
        this.player = this.players[0];
    }

    /**
     * should be in a service !
     */
    getAllPlayers(): Observable<Player[]> {
        return this._http.get('http://vbl-dva-xubuntu15.dev.gnc:10600/api/v1/players')
            .map((result: Response) => result.json())
            .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
    }

    selectedPlayer(player: Player) {
        this.player = player;
    }

    newPlayer(player: Player) {
        if (player.lastName.length > 0 && player.firstName.length > 0) {
            const exists = this.players.reduce(function (prev, curr) {
                return (curr.lastName === player.lastName && curr.firstName === player.firstName) ? curr : prev;
            }
                , null);
            if (exists === null) {
                this.players.push(player);
            }
        }
    }
}
