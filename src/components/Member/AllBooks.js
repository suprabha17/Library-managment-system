import { MDBDataTableV5 } from "mdbreact";
// import {useState} from 'react';
import ApiService from "../../services/ApiService";
// import "./AllBooks.css";
import { Link } from "react-router-dom";
// import React, { Component }  from 'react';
// import React from 'react';
import React, { useEffect, useState } from "react";

const AllBooks = () => {

    const [books, setBooks] = useState([]);
  
    const init = () => {
     ApiService.allBooks()
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
      return (
        <div className="whole-page"  >
        <div className="container" style={{marginTop:"80px"}}>
        <h3>All Book</h3> 
           <div style={{marginTop:"80px"}} >
    
          <div>
          {/* id,aadhar,first_name,middle_name,last_name, address,email, mobile, password ,dept,join_date,yr_experience,salary */}
            <table className="table table-bordered table-striped" style={{marginTop:"170px"}}>
              <thead className="thead-dark">
                <tr>
                    
                <th>Book No</th>  
                  
                  <th>Book Title</th>
                  <th>Author</th>                
                 
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
                    
                    
                  </tr>
                ))
              }
              </tbody>
            </table>
            <div className="issuebtn">
            <Link to="/member"> <button onClick={(e) => AllBooks(e)} className="btn btn-primary">Back</button></Link>
        
             </div>
          </div>
        </div>
        </div>
        </div>
      );
            }

            export default AllBooks;        