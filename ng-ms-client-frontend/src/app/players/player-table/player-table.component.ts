import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Player } from '../player';

@Component({
    selector: 'app-player-table',
    templateUrl: './player-table.component.html',
    styleUrls: ['./player-table.component.css']
})
export class PlayersTableComponent {

    @Input() players: Player[];

    @Output() selectedPlayer = new EventEmitter<Player>();

    select(player) {
        this.selectedPlayer.emit(player);
    }

}
