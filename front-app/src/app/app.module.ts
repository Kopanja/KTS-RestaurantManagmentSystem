import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { SittingTableTypesComponent } from './sitting-table-types/sitting-table-types.component';
import { RestaurantFloorComponent } from './restaurant-floor/restaurant-floor.component';
import { CreatorToolComponent } from './creator-tool/creator-tool.component';
import { TableComponent } from './table/table.component';
import { OrderComponent } from './order/order.component';
import { MenuComponent } from './menu/menu.component';
import { WaiterPageComponent } from './waiter-page/waiter-page.component';

@NgModule({
  declarations: [
    AppComponent,
    SittingTableTypesComponent,
    RestaurantFloorComponent,
    CreatorToolComponent,
    TableComponent,
    OrderComponent,
    MenuComponent,
    WaiterPageComponent,
  
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
