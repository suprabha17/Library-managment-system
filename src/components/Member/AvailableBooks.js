import { MDBDataTableV5 } from "mdbreact";
// import {useState} from 'react';
import ApiService from "../../services/ApiService";
// import "./AllBooks.css";
import { Link } from "react-router-dom";
// import React, { Component }  from 'react';
// import React from 'react';
import React, { useEffect, useState } from "react";

const AllBooks = () => {
  const[user,setuser]=useState(JSON.parse(localStorage.getItem('user')))  ;
    const [books, setBooks] = useState([]);
  
    const init = () => {
     ApiService.availableBooks()
        .then(response => {
          console.log('+++++++++Printing users data', response.data);
          setBooks(response.data);
        })
        .catch(error => {
          console.log('Something went wrong', error);
        }) 

    }
    useEffect(() => {
        init();
      }, []);
     
      const issuBook = (uid,bid) => {
        console.log('Printing id',uid,bid);
        ApiService.issueBookByMember(uid,bid)
          .then(response => {
            console.log('user deleted successfully', response.data);
            alert("📖 book issued successfully 📖 ");
            init();
          })
          .catch(error => {
           
            console.log('Something went wrong', error);
          })
      }


      return (
        <div className="whole-page"  >
        <div className="container" style={{marginTop:"80px"}}>
        <h3>Book Available in library</h3> 
           <div style={{marginTop:"80px"}} >
    
          <div>
          {/* id,aadhar,first_name,middle_name,last_name, address,email, mobile, password ,dept,join_date,yr_experience,salary */}
            <table className="table table-bordered table-striped" style={{marginTop:"170px"}}>
              <thead className="thead-dark">
                <tr>
                    
                <th>Book No</th>  
                  
                  <th>Book Title</th>
                  <th>Author</th> 
                  <th>Action</th>               
                 
                </tr>
              </thead>
              <tbody>
              {
                //id,first_name,middle_name,last_name,gender,address,mobile,dept,dob,join_date,yr_experience,salary,bonus
                books.map(books => (
                  <tr key={books.id}>
                      <td>{books.id}</td>
                    <td>{books.title}</td>
                    <td>{books.author}</td>
                    <td><button className="button_del" onClick={()=>issuBook(user.id,books.id)}>Issue</button></td>
                    
                  </tr>
                ))
              }
              </tbody>
            </table>
            <div className="issuebtn">
            <Link to="/member"> <button className="btn btn-primary">Back</button></Link>
        
             </div>
          </div>
        </div>
        </div>
        </div>
      );
            }

            export default AllBooks;        