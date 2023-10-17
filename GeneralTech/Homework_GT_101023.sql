db.createCollection("comments");

db.comments.insertMany([
  {
    _id: 1, -- Comment id
    track_id: "5f4d9b94a92b631d21ed6e46", -- The identifier of the track to which the comment relates
    user_id: 3, -- Name of the author 
    message: "Super track!", -- Comment text
    timestamp: "2023-09-09T10:00:03", -- Comment creation timestamp
    likes: 34, -- Number of likes
    dislikes: 1, -- Number of dislikes
    replies: [
      {
        user_id: 4,
        message: "Fully agree!",
        timestamp: "2023-10-17T10:15:00"
      } -- Reply to comments of another users
    ]
  },
  {
    _id: 2,
    track_id: "7f4d9b94a92b731d21ed6e00",
    user_id: 7,
    message: "The best composition of this album!",
    timestamp: "2023-09-13T22:00:08",
    likes: 100,
    dislikes: 15,
    replies: [
      {
        user_id: 9,
        message: "Before was better",
        timestamp: "2023-09-15T10:15:00"
      }
    ]
  },
  {
    _id: 3,
    track_id: "5f4d9b94a92b631d21ed6e46",
    user_id: 5,
    message: "I can't stop listening to this!",
    timestamp: "2023-09-09T14:30:22",
    likes: 50,
    dislikes: 3,
    replies: [
      {
        user_id: 6,
        message: "Me too! It's on repeat!",
        timestamp: "2023-09-10T08:45:00"
      }
    ]
  },
  {
    _id: 4,
    track_id: "5f4d9b94a92b631d21ed6e46",
    user_id: 8,
    message: "This track brings back memories",
    timestamp: "2023-09-10T17:12:15",
    likes: 22,
    dislikes: 0,
    replies: []
  },
  {
    _id: 5,
    track_id: "7f4d9b94a92b731d21ed6e00",
    user_id: 6,
    message: "The guitar solo is amazing!",
    timestamp: "2023-09-14T09:25:10",
    likes: 75,
    dislikes: 5,
    replies: []
  },
  {
    _id: 6,
    track_id: "7f4d9b94a92b731d21ed6e00",
    user_id: 10,
    message: "I can't get enough of this song!",
    timestamp: "2023-09-15T15:40:30",
    likes: 60,
    dislikes: 2,
    replies: [
      {
        user_id: 11,
        message: "It's a masterpiece!",
        timestamp: "2023-09-16T11:20:00"
      }
    ]
  },
  {
    _id: 7,
    track_id: "7f4d9b94a92b731d21ed6e00",
    user_id: 9,
    message: "I wish the lyrics were included in the description.",
    timestamp: "2023-09-17T13:55:40",
    likes: 40,
    dislikes: 10,
    replies: []
  }
])
