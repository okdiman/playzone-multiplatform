//
//  HomeScreen.swift
//  iosApp
//
//  Created by Дмитрий Окунев on 11.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct HomeScreen: View {
    private let viewModel = HomeViewModel()
    @State private var isProfilePresented = false
    
    var body: some View {
        ObservingView (statePublisher:
            statePublisher(viewModel.viewStates())){ viewState in
            HomeView(viewState: viewState) { event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
        .sheet(isPresented: $isProfilePresented){
            Text("ProfileView")
        }
        .onReceive(sharePublisher(viewModel.viewActions())) { action in
            switch action {
            case HomeAction.ShowUserProfile():
                isProfilePresented = true
                
            default:
                break
            }
        }
    }
}
