import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import React from 'react';

// import React, { Components }  from 'react';
import Navbar from './components/Home/Navbar.js';
import Home from './components/Home/Home.js';
import About from './components/Member/About.js';
import Login from './components/Home/Login.js';
import { UserContext } from './components/UserContext.js';
import {useState} from 'react';
import MemberHome from './components/Member/MemberHome.js';
// import MemberHistory from './components/Librarian/MemberHistory.js';
import LibrarianHome from './components/Home/LibrarianHome.js';
import RegistrationForm from './components/Home/RegistrationForm';
import Features from './components/Member/Features';
import IssueBook from './components/Member/IssueBook';
import FindBook from './components/Member/FindBook';
import AvailableBooks from './components/Member/AvailableBooks';
import AllBooks from './components/Member/AllBooks';
import AllBooksl from './components/Librarian/AllBooks';
import RenewBook from './components/Member/RenewBook';
import PayFine from './components/Member/PayFine';
import AllIssueBooks from './components/Librarian/AllIssueBooks';
import AddFine from './components/Librarian/addFine';
import AllMemberDetails from './components/Librarian/AllMemberDetails';
import UpdateUserForm from './components/Librarian/UpdateUserForm';
import UpadateBook from './components/Librarian/UpdateBook';
import AddBookForm from './components/Librarian/AddBookForm';
import ReturnBook from './components/Librarian/ReturnBook';
import MemberRegistration from "./components/Home/MemberRegistration.js";
import AuthorsBook from "./components/Member/AuthorsBook";
import TitlesBook from "./components/Member/TitlesBook";
import ForgetPassword from "./components/Home/ForgetPassword.js";




function App() {

  const [user, setUser] = useState(JSON.parse(localStorage.getItem('user')));

  return (
    <div className="App">
      <Router>
      <Switch>
        <UserContext.Provider value = {{user, setUser}}>
          <Navbar></Navbar>
          <div>
            <Route exact path="/authorsBook/:author" component={AuthorsBook}></Route>
          <Route exact path="/" component={Home}></Route>
          <Route exact path="/member" component={MemberHome}></Route>
          <Route exact path="/addBook" component={AddBookForm}></Route>
          <Route exact path="/forgetpassword" component={ForgetPassword}></Route>
          <Route exact path="/bookByTitle/:title" component={TitlesBook}></Route>
          {/* <Route exact path="/history" component={MemberHistory}></Route> */}
          <Route exact path="/addfine" component={AddFine}></Route>
          <Route exact path="/updateBook/:id"  component={UpadateBook}></Route>
          <Route exact path="/return" component={ReturnBook}></Route>
          <Route exact path="/about" component={About}></Route>
          <Route exact path="/about" component={About}></Route>
          <Route exact path="/login" component={Login}></Route>
          <Route exact path="/features" component={Features}></Route>
          <Route exact path="/issuebook" component={IssueBook}></Route>
          <Route exact path="/register" component={RegistrationForm}></Route>
          <Route exact path="/findbook" component={FindBook}></Route>
          <Route exact path="/availablebooks" component={AvailableBooks}></Route>
          <Route exact path="/allbooks" component={AllBooks}></Route>
          <Route exact path="/allbooksl" component={AllBooksl}></Route>
          <Route exact path="/LibrarianHome" component={LibrarianHome}></Route>
          <Route exact path="/renewbook" component={RenewBook}></Route>
          <Route exact path="/payfine" component={PayFine}></Route>
          <Route exact path="/allissuebooks" component={AllIssueBooks}></Route>
          <Route exact path="/allmemberdetails" component={AllMemberDetails}></Route>
          <Route exact path="/libr/member/:id" component={UpdateUserForm}></Route>
          <Route exact path="/member" component={MemberRegistration}></Route>
</div>





        </UserContext.Provider>
      </Switch>
    </Router>

    </div>

  );
}

export default App;