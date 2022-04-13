
import React from 'react'
import './about.css'

const About = () => {
    return (
        <div>
            <div className="bg-dark">
                <div className="container text-white py-5">
                    <div className="row h-100 align-items-center py-5">
                        <div className="col-lg-6">
                            <h1 className="display-4">About us</h1>
                            <p className="lead mb-0">AspiringReads is our effort to simplify the reading efforts of millions of users by providing easy access centralized system for all there reading requirements.</p>
                        </div>
                        <div className="col-lg-6 d-none d-lg-block"><img src="images/about.png" alt="" className="img-fluid" /></div>
                    </div>
                </div>
            </div>

            <div className="bg-white py-5">
                <div className="container py-5">
                    <div className="row align-items-center mb-5">
                        <div className="col-lg-6 order-2 order-lg-1"><i className="fas fa-book fa-2x mb-3 text-primary" ></i> 
                            <h2 className="font-weight-light">What is AspiringReads?</h2>
                            <p className="font-italic text-muted mb-4">AspiringReads helps reader to track their reading history through a centralized and secure place. We providing good service of book exchange i.e issue and book renew. We make tracking simpler, because getting information doesn’t need to be any harder!</p>
                        </div>
                        <div className="col-lg-5 px-5 mx-auto order-1 order-lg-2"><img src="images/healthify.jpg" alt="" className="img-fluid mb-4 mb-lg-0" /></div>
                    </div>
                </div>
            </div>

            <div className="bg-dark py-5">
                <div className="container py-5">
                    <div className="row mb-4">
                        <div className="col-lg-5">
                            <h2 className="display-4 font-weight-light text-white">Our team</h2>
                            <p className="font-italic text-light">Meet our Librarien.</p>
                            <p className="lead text-muted">Inspire with us!!</p>
                        </div>
                    </div>

                    <div className="row text-center">
                        <div className="col-xl-3 col-sm-6 mb-5">
                            <div className="bg-white rounded shadow-sm py-5 px-4"><img src="images/1.jpeg" alt="" width="100" className="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm" />
                                <h5 className="mb-0">Swati Ghune</h5>
                                {/* <span className="small  text-muted">CEO - Founder</span> */}
                                <ul className="social mb-0 list-inline mt-3">
                                    <li className="list-inline-item"><a href="!#" className="social-link"><i className="fab fa-google"></i></a></li>
                                    <li className="list-inline-item"><a href="!#" className="social-link"><i className="fab fa-instagram"></i></a></li>
                                    <li className="list-inline-item"><a href="!#" className="social-link"><i className="fab fa-linkedin"></i></a></li>
                                </ul>
                            </div>
                        </div>

                        <div className="col-xl-3 col-sm-6 mb-5">
                            <div className="bg-white rounded shadow-sm py-5 px-4"><img src="images/5.jpeg" alt="" width="100" className="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm" />
                                <h5 className="mb-0">Suprabha Pawar</h5>
                                {/* <span className="small text-muted">Designer</span> */}
                                <ul className="social mb-0 list-inline mt-3">
                                    <li className="list-inline-item"><a href="!#" className="social-link"><i className="fab fa-google"></i></a></li>
                                    <li className="list-inline-item"><a href="!#" className="social-link"><i className="fab fa-instagram"></i></a></li>
                                    <li className="list-inline-item"><a href="!#" className="social-link"><i className="fab fa-linkedin"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>

        </div>
    )
}

export default About
