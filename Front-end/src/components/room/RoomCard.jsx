import React from "react";
import { Card, Col } from "react-bootstrap";
import { Link } from "react-router-dom";

const RoomCard = ({ room }) => {
  return (
    <Col key={room.id} className="mb-4" xs={12}>
      <Card>
        <Card.Body className="d-flex flex-warp align-item-center">
          <div className="flex-shrink-0 mr-3 mb-3 mb-md-0">
            <Card.Img
              variant="top"
              src={`data:image/png;base64, ${room.photo}`}
              alt="Room Photo"
              style={{ width: "100%", maxWidth: "200px", height: "auto" }}
            />
          </div>
          <div className="flex-grow-1 ml-3 px-5">
            <Card.Title className="hotel-color">{room.roomType}</Card.Title>
            <Card.Title className="room-price">{room.roomPrice}</Card.Title>
            <Card.Title>
              Some room information goes here for the guest to read through
            </Card.Title>
          </div>
          <div className="flex-shrink-0 mt-3">
            <Link to={`booking/${room.id}`} className="btn btn-hotel btn-sm">
              View/Book Now
            </Link>
          </div>
        </Card.Body>
      </Card>
    </Col>
  );
};

export default RoomCard;
