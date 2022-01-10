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
import { DevPageComponent } from './dev-page/dev-page.component';
import { CookPageComponent } from './cook-page/cook-page.component';
import { BartenderPageComponent } from './bartender-page/bartender-page.component';
import { OrderCardComponent } from './order-card/order-card.component';
import { ManagerPageComponent } from './manager-page/manager-page.component';
import { HeaderTitleComponent } from './util/header-title/header-title.component';
import { ManagerPageSideMenuComponent } from './manager-page/manager-page-side-menu/manager-page-side-menu.component';
import { FormsModule } from '@angular/forms';

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
    DevPageComponent,
    CookPageComponent,
    BartenderPageComponent,
    OrderCardComponent,
    ManagerPageComponent,
    HeaderTitleComponent,
    ManagerPageSideMenuComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    DragDropModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
