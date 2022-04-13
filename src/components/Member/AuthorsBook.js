import { useForm } from 'react-hook-form';
import React, { useState,useEffect } from 'react';
import classNames from 'classnames';
import { useRef } from 'react';
import ApiService from '../../services/ApiService';
import { useHistory,useParams, } from 'react-router-dom';
import { Link } from "react-router-dom";
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
// import React, { Component }  from 'react';
 
 
function AuthorsBook(){
    const [books,setBooks] = useState([]);
    const history = useHistory();
    //   const [author1,setAuthor1] = useState(useParams());
      const {author} = useParams();
      const init = () => {

        ApiService.bookByAuthor(author)
           .then(response => {
            console.log('+++++++++Printing users data',author);
             console.log('+++++++++Printing users data', response.data);
           
             setBooks(response.data);
             if(response==null)
             toast("this author's book is not avilable in library");
   
           })
           .catch(error => {
            alert("this author's book is not avilable in library");
            history.push("/findbook");
             console.log('Something went wrong', error);
           }) 
   
       }
       useEffect(() => {
           init();
         }, []);
      return(
        <>
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
                books.map(book => (
                  <tr key={book.id}>
                      <td>{book.id}</td>
                    <td>{book.title}</td>
                    <td>{book.author}</td>
                    
                    
                  </tr>
                ))
              }
              </tbody>
            </table>
            <div className="issuebtn">
            <Link to="/findbook"> <button  className="btn btn-primary">Back</button></Link>
        
             </div>
          </div>
        </div>
        </div>
        </div>
        <ToastContainer/>
        </>);
  }
  
  export default AuthorsBook;