import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
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
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NewTableFormComponent } from './new-table-form/new-table-form.component';
import { LoginUsrnPassComponent } from './login-usrn-pass/login-usrn-pass.component';
import { LoginPinComponent } from './login-pin/login-pin.component';
import { AuthenticationService } from './services/authentication.service';
import { CanActivateAuthGuard } from './services/can-activate-auth.guard';
import { ItemCategoryService } from './services/item-category.service';
import { JwtUtilServiceService } from './services/jwt-util-service.service';
import { MenuService } from './services/menu.service';
import { SelectedTableService } from './services/selected-table.service';
import { TableTypeService } from './services/table-type.service';
import { WebSocketService } from './services/web-socket.service';
import { TokenInterceptorService } from './services/token-interceptor.service';
import { UserListComponent } from './user-list/user-list.component';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './home/home.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NewUserFormComponent } from './new-user-form/new-user-form.component';
import { ItemListComponent } from './item-list/item-list.component';

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
    NewTableFormComponent,
    LoginUsrnPassComponent,
    LoginPinComponent,
    UserListComponent,
    UserComponent,
    HomeComponent,
    AdminPageComponent,
    NavbarComponent,
    NewUserFormComponent,
    ItemListComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    DragDropModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    AuthenticationService,
    CanActivateAuthGuard,
    ItemCategoryService,
    JwtUtilServiceService,
    MenuService,
    SelectedTableService,
    TableTypeService,
    WebSocketService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },  
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
