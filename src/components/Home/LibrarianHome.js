import React from 'react';
// import './LibrarianHome.css';
import { Link } from "react-router-dom";


const LibrarianHome = (props) => {
    return (
        <div>
            <div className="bg-dark py-5">
                <div className="container py-5">
                    <div className="row text-center">

                    <div className="col-xl-3 col-sm-6 mb-5">
                            <div className="bg-white rounded shadow-sm py-5 px-4"><img src="images/1.jpeg" alt="" width="100" className="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm" />
                            <Link to="/addBook" className="nav-link px-8 text-black "><h5>Add Book</h5></Link>
                            </div>
                        </div>
                        <div className="col-xl-3 col-sm-6 mb-5">
                            <div className="bg-white rounded shadow-sm py-5 px-4"><img src="images/1.jpeg" alt="" width="100" className="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm" />
                            <Link to="/allbooksl" className="nav-link px-8 text-black "><h5>Book Details</h5></Link>
                            </div>
                        </div>

                        <div className="col-xl-3 col-sm-6 mb-5">
                            <div className="bg-white rounded shadow-sm py-5 px-4"><img src="images/5.jpeg" alt="" width="100" className="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm" />
                            <Link to="/allmemberdetails" className="nav-link px-8 text-black "><h5>Member Details</h5></Link>
                            </div>
                        </div>

                        <div className="col-xl-3 col-sm-6 mb-5">
                            <div className="bg-white rounded shadow-sm py-5 px-4"><img src="images/5.jpeg" alt="" width="100" className="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm" />
                            <Link to="/allissuebooks" className="nav-link px-8 text-black "><h5>Issue Book Details</h5></Link>
                            </div>
                        </div>

                        <div className="col-xl-3 col-sm-6 mb-5">
                            <div className="bg-white rounded shadow-sm py-5 px-4"><img src="images/5.jpeg" alt="" width="100" className="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm" />
                            <Link to="/addfine" className="nav-link px-8 text-black "><h5>Add Fine</h5></Link>
                            </div>
                        </div>
                        <div className="col-xl-3 col-sm-6 mb-5">
                            <div className="bg-white rounded shadow-sm py-5 px-4"><img src="images/5.jpeg" alt="" width="100" className="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm" />
                            <Link to="/return" className="nav-link px-8 text-black "><h5>ReturnBook</h5></Link>
                            </div>
                        </div>
                        </div>
                </div>
            </div>

        </div>
    )
}

export default LibrarianHome
