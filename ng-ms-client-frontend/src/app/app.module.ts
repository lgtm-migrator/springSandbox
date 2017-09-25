import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { PlayersPageComponent } from './players/players.component';
import { PlayersTableComponent } from './players/player-table/player-table.component';
import { PlayerFormComponent } from './players/player-form/player-form.component';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent,
    PlayersPageComponent,
    PlayersTableComponent,
    PlayerFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
