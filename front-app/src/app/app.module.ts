import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { SittingTableComponent } from './sitting-table/sitting-table.component';
import { SittingTableTypesComponent } from './sitting-table-types/sitting-table-types.component';
import { RestaurantFloorComponent } from './restaurant-floor/restaurant-floor.component';
@NgModule({
  declarations: [
    AppComponent,
    SittingTableComponent,
    SittingTableTypesComponent,
    RestaurantFloorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    DragDropModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
